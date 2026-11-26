# Activity 4: The EDT Rule — Observations

## FreezeDemo.java (BAD Practice)
- Clicking **"Freeze the UI"** executes `Thread.sleep(5000)` directly inside the button's `ActionListener`, which runs on the Event Dispatch Thread (`AWT-EventQueue-0`).
- Because the EDT is blocked for 5 seconds, the event loop cannot process any other UI events: the label does not repaint to `"Working..."` right away, the window cannot be moved or resized, and clicking the button again has no effect until the 5-second sleep finishes and the label updates to `"Done!"`.

## FixedDemo.java (GOOD Practice)
- Clicking **"Do Long Operation"** updates the status label to `"Working..."`, disables the button (`button.setEnabled(false)`), and starts a separate background `Thread` to run `Thread.sleep(5000)`.
- While the background thread sleeps, the EDT remains free to handle events, so the window stays completely responsive—it can be moved and resized freely.
- Once the background task completes, `SwingUtilities.invokeLater(...)` schedules the GUI update (`status.setText("Done!")` and `button.setEnabled(true)`) back onto the EDT safely.
