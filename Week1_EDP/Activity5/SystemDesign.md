
# Event-Driven System Design

## System Name: AfyaTrack – Kenyan Fitness Tracker

---

## Part 1: Event Sources


1. **Add 500 Steps Button** - Generates an event when the user clicks the button to record an additional 500 steps.

2. **Add 1 Glass of Water Button** - Generates an event when the user clicks the button to record one glass of water.

3. **Start Workout / Stop Workout Toggle Button** - Generates an event when the user clicks the toggle button to start or stop a workout.

4. **Reset Day Button** - Generates an event when the user clicks the button to reset the daily fitness tracking values.

5. **Application Startup (SwingUtilities)** - Generates the application initialization process when the program is launched on the Event Dispatch Thread (EDT).

---

## Part 2: Events

List all possible events in the system:

| Event Name | Source | Description |
|---|---|---|
| Add Steps Event | Add 500 Steps Button | Triggered when the user clicks the button to increase the step count by 500. |
| Add Water Event | Add 1 Glass of Water Button | Triggered when the user clicks the button to increase the water intake count by one glass. |
| Workout Toggle Event | Start Workout / Stop Workout Button | Triggered when the user clicks the toggle button to start or stop a workout. |
| Reset Day Event | Reset Day Button | Triggered when the user clicks the button to reset steps, water intake and workout status. |
| Application Initialization Event | Application Startup | Triggered when the application starts and its graphical user interface is initialized. |

---

## Part 3: Event Handlers

For each event, describe what should happen:

| Event | Handler Action |
|---|---|
| Add Steps Event | An ActionListener increases the steps variable by 500, calls updateDisplay() to refresh the dashboard and calls logEvent() to record the activity. |
| Add Water Event | An ActionListener increases the waterGlasses variable by one, updates the dashboard using updateDisplay() and records the action using logEvent(). |
| Workout Toggle Event | An ActionListener checks whether the toggle button is selected, updates the workoutActive variable, changes the button text, refreshes the dashboard and records whether the workout was started or stopped. |
| Reset Day Event | An ActionListener resets the steps and waterGlasses variables to zero, sets workoutActive to false, resets the workout toggle button, updates the dashboard and records the reset activity. |
| Application Initialization Event | SwingUtilities.invokeLater() starts the AfyaTrack application on the Event Dispatch Thread (EDT), creates the application window and makes it visible. |

---

## Part 4: Event Flow Diagram

Below is the Event Flow Diagram showing how events flow through the system:


                 USER ACTION
                      |
                      v
              EVENT SOURCE
                      |
          +-----------+-----------+
          |           |           |
          v           v           v
      Add Steps   Add Water   Workout Toggle
       Button      Button        Button
          |           |           |
          v           v           v
       Action      Action      Action
      Listener    Listener    Listener
          |           |           |
          +-----------+-----------+
                      |
                      v
                 EVENT QUEUE
                      |
                      v
                  EVENT LOOP
                      |
                      v
                EVENT HANDLERS
                      |
          +-----------+-----------+
          |                       |
          v                       v
     updateDisplay()          logEvent()
          |                       |
          v                       v
    Update Dashboard        Update Activity Log
          |                       |
          +-----------+-----------+
                      |
                      v
              UPDATED GUI DISPLAY


**Event Flow Explanation:**

1. The user interacts with one of the buttons in the AfyaTrack application.
2. The button acts as the event source and generates an event.
3. The registered ActionListener receives the event.
4. The event is processed through the Swing Event Queue and Event Dispatch Thread (EDT).
5. The appropriate event handler executes the required action.
6. The updateDisplay() method refreshes the fitness dashboard with the latest information.
7. The logEvent() method records the user's activity in the activity log.
8. The updated information is displayed on the application window.

---

## Part 5: Potential Issues

What could go wrong with this system?

1. **Incorrect Fitness Tracking Values** - Repeated or accidental button clicks may increase the steps or water intake beyond the user's actual activities.
   - **Prevention:** Introduce input validation and additional controls to allow users to correct incorrectly recorded values.

2. **Activity Log Growing Continuously** - The activity log may accumulate many messages over time, increasing memory usage.
   - **Prevention:** Introduce a mechanism to limit the number of stored activity messages or clear old records periodically.

3. **Loss of Fitness Data** - The steps, water intake and workout information are stored in memory and will be lost when the application is closed.
   - **Prevention:** Implement a database or file storage mechanism to save and retrieve the user's daily fitness information.

