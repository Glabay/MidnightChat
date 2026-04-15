package dev.midnightcoder.chat;

import java.io.PrintWriter;

/**
 * @author Glabay | Glabay-Studios
 * @project MidnightChat
 * @social Discord: Glabay
 * @since 2026-04-07
 */
public interface MidnightCommand {
    void execute(PrintWriter writer, String... args);
}
