# Activity 3: Procedural vs Event-Driven Programming

## Procedural calculator questions

1. **What is the exact order of steps in this program?**  
   The program displays a heading, asks for the first number, asks for an operator, asks for the second number, performs the calculation using a switch statement, and displays the result.

2. **What happens if the user enters the wrong input at step 2?**  
   If the user enters an unsupported operator, the default case displays “Invalid operator” and the program ends.

3. **Can the user calculate again without restarting the program?**  
   No. The program performs one calculation and then ends.

4. **Who controls the flow of this program — the user or the program?**  
   The program controls the order of execution. The user supplies input when prompted.

## Event-driven calculator questions

1. **Can the user click buttons in any order?**  
   The user can interact with the buttons in different orders, although a meaningful calculation still requires entering numbers and an operator in a suitable sequence.

2. **What happens if the user makes a mistake?**  
   The user can press C to clear the display and start again. Division by zero displays an error.

3. **Can the user calculate again without restarting?**  
   Yes. The calculator remains open and can process more button clicks.

4. **Who controls the flow — the user or the program?**  
   The user controls when actions happen by clicking buttons. The program responds to those events using registered handlers.

5. **How many event handlers are in this program?**  
   There is one ActionListener registered for each of the 16 buttons. They all call the shared `handleButton` method, which handles the button's action.

## Comparison table

| Aspect | Procedural programming | Event-driven programming |
|---|---|---|
| Who controls the flow? | The program follows a predefined sequence. | Events from the user or system trigger actions. |
| Can user make mistakes and recover easily? | Recovery is limited in this one-calculation example. | The user can press C and continue. |
| Can user interact in any order? | No. Input is requested in a fixed sequence. | The user can click controls in different orders, subject to the application's logic. |
| How many possible execution paths? | Mainly one planned sequence, with branches for operators and errors. | Many possible paths depending on the events and their order. |
| Code organization | Statements are arranged in a sequence. | Code is organized around event listeners and handlers. |
| User experience | Text-based and prompt-driven. | Interactive graphical interface. |

## Reflection

Procedural programming follows a sequence of instructions controlled by the program. Event-driven programming responds when an event such as a button click or key press occurs. I prefer event-driven programming when developing interactive applications because users can choose actions and receive immediate responses. It also makes it easier to organize a graphical interface around separate controls and their event handlers. Event-driven programming is suitable for GUIs because the application does not need to ask for every action in a fixed order. Instead, it waits for events and responds when they happen.
