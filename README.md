# CIM-CSS
This project is about developing an eclipse-based graphical editor to support modeling of context information for intelligent context-sensitive systems (CSS). Particularly, it is designed to assist context identification and management (CIM).

Contextual information can be specified in XMI format as shown in an example below:

<?xml version="1.0" encoding="UTF-8"?>
<context:ContextModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="context">
  <contextelements xsi:type="context:Composite" name="Room [r] is occupied" description="Activity" formalSpecification=""/>
  <contextelements xsi:type="context:Composite" name="Room [r] hosts meeting now"/>
  <contextelements xsi:type="context:Atomic" name="Environmental " refinementFromSubContext="//@refinements.0" description="Room [r] is noisy" contextProperty="//@properties.0"/>
  <contextelements xsi:type="context:Atomic" name="Location" refinementFromSubContext="//@refinements.0" description="There are at least two persons located at room [r]" contextProperty="//@properties.1 //@properties.3"/>
  <contextelements xsi:type="context:Atomic" name="Temporal" description="Current time" refinementFromSuperContext="//@refinements.0" contextProperty="//@properties.2"/>
  <refinements refiningContexts="//@contextelements.1"/>
  <relationships xsi:type="context:Causal" name="causes" sourceContext="//@contextelements.1" targetContext="//@contextelements.0"/>
  <sources name="Microphone"/>
  <sources name="Camera"/>
  <sources name="Digital Clock" type="Logical"/>
  <acquisitions xsi:type="context:Sensed" aquiredcontext="//@contextelements.2" contextsource="//@sources.0" name="sensedFrom"/>
  <acquisitions xsi:type="context:Sensed" aquiredcontext="//@contextelements.4" contextsource="//@sources.2" name="sensedFrom"/>
  <acquisitions xsi:type="context:Sensed" aquiredcontext="//@contextelements.3" contextsource="//@sources.1" name="sensedFrom"/>
  <entities name="Meeting Room [r]" type="Place"/>
  <characterizations name="characterizes" charEntity="//@entities.0" charContext="//@contextelements.1"/>
  <foci focalElement="G1 = Achieve[LightsSwitchedOn]" agent="A1 = Light Controller [lc1]" role="R1: Assignment (lc1, G1)" entity="" priority="Important" name="Focus: F1"/>
  <relevance focus="//@foci.0" relevantContext="//@contextelements.1" name="relevance"/>
  <valuesin property="//@properties.2" range="//@ranges.0" name="valuesIn"/>
  <valuesin property="//@properties.0" range="//@ranges.1" name="valuesIn"/>
  <ranges name="10:30"/>
  <ranges name="High"/>
  <properties name="noise level"/>
  <properties name="location"/>
  <properties name="time"/>
  <properties name="location"/>
</context:ContextModel>
