# Activity 6: Complete Interactive Swing Application (`InteractiveStudentPortal`)

An event-driven Java Swing desktop application (`InteractiveStudentPortal.java`) that upgrades the Week 3 static Student Portal mockup into a fully interactive multi-view application using Week 4 event handling concepts.

## Learning Outcomes Covered

- **ActionListener**: Menu items (`File`, `View`, `Help`), header `Logout` button, shared sidebar navigation listener (`e.getActionCommand()`), `JComboBox` term/day selectors, course enrollment button, fee receipt button, and message submission.
- **ItemListener**: Dashboard `Show urgent only` `JCheckBox`, Courses semester `JRadioButton` filter group, and Fees payment method `JRadioButton` group.
- **DocumentListener**: Real-time course search filtering (`JTextField.getDocument()`) and live character count (`0 / 200`, turning red above 200) on the advisor message `JTextArea`.
- **Event Dispatch Thread (EDT) & Layout Management**: Launches inside `SwingUtilities.invokeLater(...)` and combines `BorderLayout`, `GridLayout`, `BoxLayout`, `FlowLayout`, and `CardLayout`.

## Application Sections

| Section | Components & Listeners | Functionality |
| --- | --- | --- |
| **Menu Bar & Header** | `JMenuBar`, `JMenuItem`, `JButton` (`ActionListener`) | Refresh status, jump to any section, open About dialog, or confirm logout/exit |
| **Sidebar** | 6 `JButton`s sharing one `ActionListener` | Switches `CardLayout` panels, highlights the active button, and updates the status bar |
| **Dashboard** | Stat cards (`GPA`, `Units`, `Fees`), `JCheckBox` (`ItemListener`), `JList` | Filters notifications to show either all items or `[Urgent]` items only |
| **Courses** | `JTextField` (`DocumentListener`), `JRadioButton`s (`ItemListener`), `JButton` (`ActionListener`) | Live search by keyword and semester (`All`, `Semester 1`, `Semester 2`) plus course enrollment |
| **Grades** | `JComboBox` (`ActionListener`), `JTextArea` | Displays grades and GPA for `Semester 2 (2026)` or `Semester 1 (2026)` |
| **Fees** | `ButtonGroup` of `JRadioButton`s (`ItemListener`), `JButton` (`ActionListener`) | Updates payment instructions (`M-Pesa`, `Bank Transfer`, `Credit / Debit Card`) and generates a receipt dialog |
| **Timetable** | `JComboBox` (`ActionListener`), `JLabel` | Displays scheduled classes for `Monday`, `Wednesday`, or `Friday` |
| **Messages** | `JTextArea` (`DocumentListener`), `JButton` (`ActionListener`) | Live character counter (`0 / 200`) and non-empty / length validation before sending |
| **Status Bar** | `JLabel` (`statusLabel`) | Updates dynamically in response to user actions |

## Architecture Overview

1. `main` calls `SwingUtilities.invokeLater(...)` so all Swing components are created on the EDT.
2. `createAndShow()` builds the `JFrame` (`950 × 620`, `BorderLayout`) and attaches the status bar (`SOUTH`) before `createCenterCards()` (`CENTER`), ensuring `statusLabel` is initialized before initial panel population calls `updateStatus(...)`.
3. `navigateTo(String section)` uses `cardLayout.show(centerCards, section)`, updates sidebar button styling via `highlightNavButton(section)`, and updates the status bar.

## How to Compile and Run

From the `activity6-complete-app` directory:

```powershell
javac InteractiveStudentPortal.java
java InteractiveStudentPortal
```
