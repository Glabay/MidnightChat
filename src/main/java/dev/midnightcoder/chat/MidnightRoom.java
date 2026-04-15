package dev.midnightcoder.chat;

import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Glabay | Glabay-Studios
 * @project MidnightChat
 * @social Discord: Glabay
 * @since 2026-04-06
 */
public class MidnightRoom {
    private final Map<String, PrintWriter> clients = new ConcurrentHashMap<>();

    public boolean join(String username, PrintWriter writer) {
        if (clients.containsKey(username)) {
            writer.println("Username already taken");
            return false;
        }
        clients.put(username, writer);
        return true;
    }

    public void broadcast(String sender, String message) {
        var formattedMessage = "[%s]: %s".formatted(sender, message);
        clients.forEach((_, writer) ->
            writer.println(formattedMessage));
    }
}
