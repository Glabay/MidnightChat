package dev.midnightcoder.chat;

import java.net.ServerSocket;

/**
 * @author Glabay | Glabay-Studios
 * @project MidnightChat
 * @social Discord: Glabay
 * @since 2026-04-06
 */
public class MidnightServer {

    void main() {
        var room = new MidnightRoom();
        try (var server = new ServerSocket(42069)) {
            IO.println("Server started on port 42069");

            while (true) {
                var socket = server.accept();
                Thread.startVirtualThread(new MidnightSession(socket, room));
            }
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
