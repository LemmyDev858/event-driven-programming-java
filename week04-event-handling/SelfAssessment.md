# Week 4: Final Self-Assessment

## Learning Outcome 1: Implement ActionListener using multiple techniques

**Rate yourself 1–5:** 5

**Three ways to implement an `ActionListener`:**

1. Named class (`class MyListener implements ActionListener`)
2. Anonymous inner class (`new ActionListener() { ... }`)
3. Lambda expression (`e -> { ... }`) *(plus method reference `ClassName::methodName`)*

## Learning Outcome 2: Handle state changes in checkboxes, radio buttons, and text fields

**Rate yourself 1–5:** 5

- **Which listener handles checkbox state changes?** `ItemListener` (via `itemStateChanged(ItemEvent e)`)
- **Which listener handles text field changes?** `DocumentListener` (via `insertUpdate`, `removeUpdate`, and `changedUpdate` on `getDocument()`)

## Learning Outcome 3: Differentiate between listener interfaces

**Rate yourself 1–5:** 5

**Match the component to the listener:**

| Component | Listener |
| --- | --- |
| `JButton` | `ActionListener` |
| `JCheckBox` | `ItemListener` |
| `JTextField` | `DocumentListener` |
| Mouse hover | `MouseListener` |
| Key press | `KeyListener` |

## Learning Outcome 4: Build an interactive Swing application

**Rate yourself 1–5:** 5

**Did your Interactive Registration Form work?**

- [x] Yes
- [ ] No
