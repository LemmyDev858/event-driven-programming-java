# Week 3: Final Self-Assessment

## Learning Outcome 1: Create a functional Swing application with a main window

**Minimal code to create a JFrame:**

```java
import javax.swing.*;

public class MinimalFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My First Swing App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
```

## Learning Outcome 2: Add, customize, and arrange components using layouts
Rate Score: 5/5

**Four layout managers and one use case for each:**

| Layout | Use Case |
| --- | --- |
| `FlowLayout` | Row of buttons / toolbar that wraps when full |
| `BorderLayout` | Main window shell with header (`NORTH`), sidebar (`WEST`), main content (`CENTER`), and status bar (`SOUTH`) |
| `GridLayout` | Equal-sized cells in a fixed grid (e.g., calculator keypad or 3x3 card grid) |
| `BoxLayout` | Vertical stack of items (`BoxLayout.Y_AXIS`) in a content panel |

## Learning Outcome 3: Ensure GUI code runs on the EDT
Rate Score: 5/5

**The two golden rules of Swing threading:**

1. All GUI creation and updates must happen on the EDT (`SwingUtilities.invokeLater(...)`).
2. Never perform long operations on the EDT (run them on a background `Thread`, then update the GUI on the EDT via `SwingUtilities.invokeLater(...)`).

## Learning Outcome 4: Build a static, non-interactive UI layout

- `StudentPortal.java` in `activity5-complete-mockup/` implements the complete static University Student Portal layout using nested `BorderLayout`, `GridLayout`, `BoxLayout`, and `FlowLayout`.
