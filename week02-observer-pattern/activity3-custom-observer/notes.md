# Activity 3: Coupling Problem & Comparison Notes

## Step 2: Identify the Coupling Problem

1. **What happens if we want to add a third display class? Do we have to modify DataModel?**
   Yes. In `TightlyCoupledSystem`, `DataModel.setValue()` directly instantiates and calls methods on every display class (`new LabelDisplay().showValue(value)` and `new BarChartDisplay().drawBar(value)`). Adding a third display forces us to edit `DataModel`.

2. **What happens if LabelDisplay is deleted or renamed?**
   `DataModel` will fail to compile because it has a direct compile-time dependency on `LabelDisplay` and its `showValue(int)` method.

3. **Can we easily test DataModel in isolation?**
   No. Because `DataModel` directly creates and invokes `LabelDisplay` and `BarChartDisplay` inside `setValue()`, we cannot test `DataModel` without those concrete display classes existing and executing.

## Step 4: Compare the Two Systems

| Aspect | Tightly Coupled | Observer Pattern |
|--------|-----------------|------------------|
| Adding a new display | Modify DataModel | Just register a new observer |
| Testing DataModel in isolation | Hard — it needs display classes | Easy — no display classes required |
| Removing a display | Modify DataModel | Just don't register it |
