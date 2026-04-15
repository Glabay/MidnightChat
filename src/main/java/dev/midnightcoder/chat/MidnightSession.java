package dev.midnightcoder.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Glabay | Glabay-Studios
 * @project MidnightChat
 * @social Discord: Glabay
 * @since 2026-04-06
 */
public class MidnightSession implements Runnable {
    private final Socket socket;
    private final MidnightRoom room;

    public MidnightSession(Socket socket, MidnightRoom room) {
        this.socket = socket;
        this.room = room;
    }

    @Override
    public void run() {
        try (
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("===================================");
            out.println("Welcome to the MidnightChat server!");
            out.println("===================================");
            out.println("Enter a username:");
            var username = in.readLine();
            var joined = room.join(username.toLowerCase(), out);
            if (!joined) return;
            room.broadcast("Server", "%s joined the chat".formatted(username));
            String line;
            while ((line = in.readLine()) != null) {
                if (parseCommand(line, out)) continue;
                room.broadcast(username, line);
            }
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private boolean parseCommand(String command, PrintWriter out) {
        var cmd = command.toLowerCase();
        if (cmd.startsWith("/help")) {
            new HelpCommand().execute(out);
            return true;
        }
        return false;
    }
}
