package dev.midnightcoder.chat;

import java.io.PrintWriter;

/**
 * @author Glabay | Glabay-Studios
 * @project MidnightChat
 * @social Discord: Glabay
 * @since 2026-04-07
 */
public class HelpCommand implements MidnightCommand {
    @Override
    public void execute(PrintWriter out, String... args) {
        out.println("==================");
        out.println("Midnight Commands:");
        out.println("==================");
        out.println("/help - Displays this message");
    }
}
