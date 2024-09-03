# Willkommen zur Kundenverwaltung.
Dies ist ein Übungsprojekt für die Kundenverwaltung

# Aufbau
Das Projekt enthält eine einfache 2 Schichten Architektur. In LF11a programmieren wir das Backend und in LF10a das passende Frontend. Die Projekte laufen aber unabhängig und werden erst am Ende zusammengeführt.

Es enthält somit folgende wichtige Bereiche im Paket **de.oszimt.fian.hase**

* **HaseGmbHClientStart**: Startklasse. Hier wird entschieden ob es per Console oder GUI gestartet wird.
* **view.console**: Hier liegt die Ausgabe der Console, d.h. unsere Konsolenprogrammierung.
* **view.gui**: Hier liegt die Ausgabe der GUI, d.h. die LF10a Programmierung.
* **model**: Hier finden Sie alle Datenklassen. Hier werden Sie sehr viel programmieren.
* **tests**: Hier liegen alle Unittests zur automatisierten Prüfung des Projekts. Diese sind später auch Bewertungsbestandteil in LF11a. Wie diese genau funktionieren, erfahren Sie LF10a.
* **Ausführen von Tests**:
  * Eclipse: Rechtsklick auf die Testklasse und Run as > JUnit Test
  * IDEA: Rechtsklick auf die Testklasse und Run Klassenname.