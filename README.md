TI Logic Project 1
=================

Theoretische Informatik: Logik
WS 2013/2014
1. Projektaufgabe: SAT-Solver
Abgabe: bis Freitag, den 22.11.2013, in Moodle
Diese Projektaufgabe soll grundsa ̈tzlich in Gruppen zu 4-6 Studenten bearbeitet werden. Es genu ̈gt, wenn ein Mitglied einer Gruppe die fertige Quelldatei (bei mehr als einer, bitte als Archiv abgeben) in Moodle einreicht. Achten Sie bitte darauf, dass in Ihrer Abgabe alle Gruppenmitglieder benannt sind. Zur erfolgreichen Absolvierung dieser Aufgabe geho ̈rt eine kurze (5-10 min) Pra ̈sentation Ihrer Lo ̈sung inklusive einer anschließenden Diskussion u ̈ber die zugrundeliegenden Konzepte (5-10 min). Aus diesem Grund wird sich Richard nach der Abgabe mit jeder Gruppe zwecks Terminfindung in Verbindung setzen.
Viele in der Praxis wichtige und interessante Probleme lassen sich durch aussagenlogische For- meln modellieren. Eine Antwort auf die Frage, ob eine solche Formel erfu ̈llbar ist, liefert dann auch eine Antwort auf die Frage, ob das gegebene Problem eine Lo ̈sung besitzt. Ist dies der Fall, dann gibt uns ein Modell der Formel bestenfalls Aufschluss u ̈ber die Lo ̈sung selbst. (Einige Beispiele dafu ̈r werden Sie in der Vorlesung kennenlernen.)
Hier kommen SAT-Solver ins Spiel. Ein SAT-Solver ist nichts anderes als ein Algorithmus zur Lo ̈sung des Erfu ̈llbarkeitsproblems der Aussagenlogik. Dabei ist klar, dass eine Lo ̈sung oder bes- ser ein naiver Algorithmus zur Lo ̈sung dieses Erfu ̈llbarkeitsproblems schnell konstruiert werden kann (also in anderen Worten: das Erfu ̈llbarkeitsproblem der Aussagenlogik ist entscheidbar), dieser jedoch im Allgemeinen exponentiell la ̈uft in Abha ̈ngigkeit der Formelgro ̈ße.
Ihre Aufgabe ist es nun, einen solchen SAT-Solver in JAVA zu implementieren. Dafu ̈r werden Sie das erforderliche theoretische Ru ̈stzeug in den kommenden Wochen in der Vorlesung und U ̈bung erhalten. Dort werden sowohl naive Lo ̈sungsansa ̈tze als auch einige Optimierungen vorgestellt und diskutiert werden.
AUFGABE: Implementieren Sie einen SAT-Solver in JAVA, der folgendes leisten soll:
• Eingabe: Aussagenlogische Formel als Zeichenkette mit folgender syntaktischer Konventi-
on:
– aussagenlogische Variablen entsprechen
Wo ̈rtern der Form {A,B,...,Z}{a,b,...,z,0,1,...,9}∗
– Konjunktion “∧” entspricht &
– Disjunktion “∨” entspricht |
– Negation “¬” entspricht -
– Implikation “→” entspricht ->
– Bi-Implikation “↔” entspricht <->
Beispiel: A1 & (-A2 -> B0) wa ̈re die Zeichenkette, die einer Formel der Form A1 ∧ (¬A2 → B0) entspricht.
• Ausgabe: Im Falle der syntaktischen Korrektheit der eingelesenen aussagenlogischen For- mel soll ausgegeben werden, ob diese erfu ̈llbar ist oder nicht. Im Falle der Erfu ̈llbarkeit soll ferner ein Modell ausgegeben werden.
￼￼
Hinweis: Folgende Vorgehensweise zur Lo ̈sung der Aufgabe kann hilfreich sein.
1. Sie beno ̈tigen zuna ̈chst einen Parser fu ̈r Zeichenketten der oben spezifizierten Form. Dessen Aufgabe ist natu ̈rlich die U ̈berpru ̈fung der syntaktischen Korrektheit der eingegebenen Formel sowie das U ̈bersetzen in eine gewa ̈hlte Datenstruktur. (Dazu liefert bereits die erste Woche der Vorlesung wichtige Hinweise.)
Zur Unterstu ̈tzung stellen wir die no ̈tigen Informationen zur Verfu ̈gung, um mit Hilfe des Parsergenerators CUP sowie des Lexergenerators JFlex einen Parser zu erstellen. Eine Do- kumentation dieser Tools sowie Links zum Download finden sie auf http://www2.cs.tum.edu/projects/cup/ und http://jflex.de/.
Auf der Moodle-Seite des Kurses bieten wir ein ZIP-Archiv an, welches folgende Dateien entha ̈lt.
• scanner.yy: die Spezifikation des Lexers, welche die Zuordnung der jeweiligen Zei- chenketten (z.B. <->) zu Tokens (z.B. BIIMP) beschreibt.
• parser.cup: die Spezifikation der Grammatik zur eigentlichen Erzeugung des Parsers. Dort werden die Tokens des Lexers als Terminale der Grammatik verwendet.
• Formel.java usw.: eine Klassenhierarchie zur Modellierung von aussagenlogischen Formeln.
• Main.java: ein Beispielprogramm, welches zeigt, wie der Parser aufzurufen ist.
Mit dem Befehl
     jflex-1.4.3/jflex/bin/jflex scanner.yy
wird der Lexer erzeugt. Anschließend kann mit
     java -jar java-cup-11a.jar parser.cup
der Parser erzeugt werden.
Zur Kompilierung sowie zur Ausfu ̈hrung mu ̈ssen Sie CUP noch verfu ̈gbar machen:
     javac -classpath java-cup-11a.jar:. *.java
     java -classpath java-cup-11a.jar:. Main
Natu ̈rlich mu ̈ssen Sie nicht den von uns zur Verfu ̈gung gestellten Parser und/oder die Datenstruktur nutzen.
2. Implementieren Sie dann den eigentlichen SAT-Solver. Dazu werden, wie bereits erwa ̈hnt, im weiteren Verlauf der Vorlesung verschiedenste Mo ̈glichkeiten und Optimierungen vor- gestellt. Z.B. kann es zuna ̈chst hilfreich sein, die eingelesene Formel in eine algorithmisch besser handhabbare Form zu bringen.
3. Prinzipiell sollte ihr SAT-Solver erst einmal funktionieren. Jedoch werden wir bei der Kontrolle der Lo ̈sungen auch auf Effizienz Wert legen und die “schnellsten” Lo ̈sungen ggf. pra ̈mieren. D.h. nutzen Sie die vorgestellten Optimierungen, oder u ̈berlegen Sie sich eigene mo ̈glichst “clevere” Verfahren, die Erfu ̈llbarkeit der gegebenen Formel zu verifizieren.
