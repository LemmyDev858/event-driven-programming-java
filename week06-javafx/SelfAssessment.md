# Week 6: Final Self-Assessment

## Learning Outcome 1: Create a basic JavaFX application

- [x] I can create a Stage, Scene, and Root Node from memory.
- [x] I can run the app using NetBeans Run File button.

## Learning Outcome 2: Design UI layouts (Programmatic & FXML)

- [x] I understand the difference between VBox, HBox, and BorderPane.
- [x] I can open Scene Builder, drag components, and save an FXML file.

## Learning Outcome 3: JavaFX Architecture & Threading

- [x] I know the JavaFX UI thread is called the "JavaFX Application Thread".
- [x] I understand why long operations must not block this thread.

## Learning Outcome 4: Build a functional application

- [x] I successfully wired a button in FXML to a method in a Controller using `onAction`.
- [x] I successfully completed the Capstone Dashboard.

---

### Step 1.5: Self-Check Questions

**Q1: What is the difference between a Stage and a Scene?**
`Stage` is the physical window (with the title bar). `Scene` is the content inside the window. A Stage can only show one Scene at a time, but you can swap Scenes.

**Q2: What is the name of the JavaFX main thread?**
`JavaFX Application Thread`. Just like the EDT in Swing, all UI updates must be done on this thread.
