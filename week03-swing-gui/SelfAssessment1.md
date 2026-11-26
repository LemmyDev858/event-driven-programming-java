# Week 3 Self-Assessment: Building GUI Applications with Swing

## Final Self-Assessment (VS Code & NetBeans Editions)

### Learning Outcome 1: Create a functional Swing application with a main window
- **Rating (1–5):** 5
- **Minimal code to create a JFrame:**
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
- **Steps to create a new NetBeans JFrame Form:**
  1. Right-click the project in the **Projects** panel.
  2. Select **New → JFrame Form...**.
  3. Enter the **Class Name** and **Package**, then click **Finish**.

### Learning Outcome 2: Add, customize, and arrange components using layouts
- **Rating (1–5):** 5
- **Four layout managers and use cases / visual appearance:**

| Layout | Use Case | Visual Appearance |
| :--- | :--- | :--- |
| `FlowLayout` | Toolbars, rows of buttons | Components flow left-to-right and wrap to the next line |
| `BorderLayout` | Main application shell (header, sidebar, content, footer) | 5 regions: `NORTH`, `SOUTH`, `EAST`, `WEST`, and expanding `CENTER` |
| `GridLayout` | Calculator keypads, uniform button/card grids | Equal-sized cells arranged in fixed rows and columns |
| `BoxLayout` | Vertical stacks of items (`Y_AXIS`) | Components stacked in a single vertical or horizontal line |

### Learning Outcome 3: Ensure GUI code runs on the EDT
- **Rating (1–5):** 5
- **The two golden rules of Swing threading:**
  1. All GUI creation and updates must happen on the Event Dispatch Thread (`SwingUtilities.invokeLater()` / `EventQueue.invokeLater()`).
  2. Never perform long-running operations on the EDT; run them on a background thread and post UI updates back to the EDT.

### Learning Outcome 4: Build a static, non-interactive UI layout
- **Rating (1–5):** 5
- **Did StudentPortal / StudentPortalForm compile and run?**
  - [x] Yes
  - [ ] No
