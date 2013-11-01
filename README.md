TI Logic Project 1 : SAT-Solver
=================

Abgabe:
-------
###bis Freitag, den 22.11.2013, in Moodle
Diese Projektaufgabe soll grundsätzlich in Gruppen zu 4-6 Studenten bearbeitet werden. Es genügt, wenn ein Mitglied einer Gruppe die fertige Quelldatei (bei mehr als einer, bitte als Archiv abgeben) in Moodle einreicht.

Achten Sie bitte darauf, dass in Ihrer Abgabe alle Gruppenmitglieder benannt sind. Zur erfolgreichen Absolvierung dieser Aufgabe gehört eine kurze (5-10 min) Präsentation Ihrer Lösung inklusive einer anschließenden Diskussion über die zugrundeliegenden Konzepte (5-10 min). Aus diesem Grund wird sich Richard nach der Abgabe mit jeder Gruppe zwecks Terminfindung in Verbindung setzen.


Viele in der Praxis wichtige und interessante Probleme lassen sich durch aussagenlogische For- meln modellieren. Eine Antwort auf die Frage, ob eine solche Formel erfüllbar ist, liefert dann auch eine Antwort auf die Frage, ob das gegebene Problem eine Lösung besitzt. Ist dies der Fall, dann gibt uns ein Modell der Formel bestenfalls Aufschluss über die Lösung selbst. (Einige Beispiele dafür werden Sie in der Vorlesung kennenlernen.)
Hier kommen SAT-Solver ins Spiel. Ein SAT-Solver ist nichts anderes als ein Algorithmus zur Lösung des Erfüllbarkeitsproblems der Aussagenlogik. Dabei ist klar, dass eine Lösung oder bes- ser ein naiver Algorithmus zur Lösung dieses Erfüllbarkeitsproblems schnell konstruiert werden kann (also in anderen Worten: das Erfüllbarkeitsproblem der Aussagenlogik ist entscheidbar), dieser jedoch im Allgemeinen exponentiell läuft in Abhängigkeit der Formelgröße.
Ihre Aufgabe ist es nun, einen solchen SAT-Solver in JAVA zu implementieren. Dafür werden Sie das erforderliche theoretische Rüstzeug in den kommenden Wochen in der Vorlesung und Übung erhalten. Dort werden sowohl naive Lösungsansätze als auch einige Optimierungen vorgestellt und diskutiert werden.

AUFGABE:
-------
###Implementieren Sie einen SAT-Solver in JAVA, der folgendes leisten soll:

* Eingabe: Aussagenlogische Formel als Zeichenkette mit folgender syntaktischer Konvention:
 * aussagenlogische Variablen entsprechen Wörtern der Form `{A,B,...,Z}{a,b,...,z,0,1,...,9}∗`
 * Konjunktion `∧` entspricht `&`
 * Disjunktion `∨` entspricht `|`
 * Negation `¬`entspricht `-`
 * Implikation `→` entspricht `->`
 * Bi-Implikation `↔` entspricht `<->`

Beispiel: `A1 & (-A2 -> B0)` wäre die Zeichenkette, die einer Formel der Form `A1 ∧ (¬A2 → B0)` entspricht.

* Ausgabe: Im Falle der syntaktischen Korrektheit der eingelesenen aussagenlogischen Formel soll ausgegeben werden, ob diese erfüllbar ist oder nicht. Im Falle der Erfüllbarkeit soll ferner ein Modell ausgegeben werden.

###Hinweis: 
Folgende Vorgehensweise zur Lösung der Aufgabe kann hilfreich sein.
1. Sie benötigen zunächst einen Parser für Zeichenketten der oben spezifizierten Form. Dessen Aufgabe ist natürlich die Überprüfung der syntaktischen Korrektheit der eingegebenen Formel sowie das Übersetzen in eine gewählte Datenstruktur. (Dazu liefert bereits die erste Woche der Vorlesung wichtige Hinweise.) Zur Unterstützung stellen wir die nötigen Informationen zur Verfügung, um mit Hilfe des Parsergenerators CUP sowie des Lexergenerators JFlex einen Parser zu erstellen. Eine Do- kumentation dieser Tools sowie Links zum Download finden sie auf http://www2.cs.tum.edu/projects/cup/ und http://jflex.de/. Auf der Moodle-Seite des Kurses bieten wir ein ZIP-Archiv an, welches folgende Dateien enthält.
  * `scanner.yy`: die Spezifikation des Lexers, welche die Zuordnung der jeweiligen Zei- chenketten (z.B. <->) zu Tokens (z.B. BIIMP) beschreibt.
  * `parser.cup`: die Spezifikation der Grammatik zur eigentlichen Erzeugung des Parsers. Dort werden die Tokens des Lexers als Terminale der Grammatik verwendet.
  * `Formel.java` usw.: eine Klassenhierarchie zur Modellierung von aussagenlogischen Formeln.
  * `Main.java`: ein Beispielprogramm, welches zeigt, wie der Parser aufzurufen ist.
  Mit dem Befehl `jflex-1.4.3/jflex/bin/jflex scanner.yy` wird der Lexer erzeugt. Anschließend kann mit `java -jar java-cup-11a.jar parser.cup` der Parser erzeugt werden. Zur Kompilierung sowie zur Ausführung müssen Sie CUP noch verfügbar machen: `javac -classpath java-cup-11a.jar:. *.java` `java -classpath java-cup-11a.jar:. Main`
  Natürlich müssen Sie nicht den von uns zur Verfügung gestellten Parser und/oder die Datenstruktur nutzen.
2. Implementieren Sie dann den eigentlichen SAT-Solver. Dazu werden, wie bereits erwähnt, im weiteren Verlauf der Vorlesung verschiedenste Möglichkeiten und Optimierungen vor- gestellt. Z.B. kann es zunächst hilfreich sein, die eingelesene Formel in eine algorithmisch besser handhabbare Form zu bringen.
3. Prinzipiell sollte ihr SAT-Solver erst einmal funktionieren. Jedoch werden wir bei der Kontrolle der Lösungen auch auf Effizienz Wert legen und die “schnellsten” Lösungen ggf. prämieren. D.h. nutzen Sie die vorgestellten Optimierungen, oder überlegen Sie sich eigene möglichst “clevere” Verfahren, die Erfüllbarkeit der gegebenen Formel zu verifizieren.
