# Bug Fix Documentation

## Bug 1: Blocking the EDT

- **Symptom:** The interface freezes when the Process button is clicked.
- **Cause:** `Thread.sleep(5000)` was executed inside the ActionListener on the Event Dispatch Thread.
- **Fix:** The simulated long operation was moved to a background thread. `SwingUtilities.invokeLater()` updates the label and button on the EDT.
- **Code change:** Created a new `Thread`, performed the delay inside it, and scheduled the GUI update with `SwingUtilities.invokeLater()`.

## Bug 2: Missing Listener

- **Symptom:** Clicking Increment does not change the count.
- **Cause:** No ActionListener was registered with the button.
- **Fix:** Added an ActionListener that increments the count and updates the label.
- **Code change:** `incrementButton.addActionListener(e -> { count++; countLabel.setText("Count: " + count); });`

## Bug 3: Wrong Thread

- **Symptom:** The clock updates a Swing component directly from a background thread, which is not safe Swing practice.
- **Cause:** `timeLabel.setText()` was called inside the worker thread.
- **Fix:** The time is created in the background thread, but the label update is scheduled on the EDT.
- **Code change:** Wrapped the label update in `SwingUtilities.invokeLater()`. A `volatile` flag is used to allow the Start/Stop control to communicate with the clock thread.

## Bug 4: Memory Leak

- **Symptom:** Buttons disappear from the interface, but the list continues to hold references to them.
- **Cause:** The buttons were removed from the panel but not from `createdButtons`.
- **Fix:** Cleared the list when removing all buttons.
- **Code change:** Added `createdButtons.clear()` after `buttonPanel.removeAll()`.

## Testing

Run each Java file separately. Confirm that the Process window remains responsive, Increment changes the count, the clock can start and stop, and Remove All removes the buttons and clears the list.
