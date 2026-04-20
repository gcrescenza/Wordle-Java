# 🧩 Wordle CLI (Java)

Un'implementazione del celebre gioco di parole **Wordle**, sviluppata interamente in **Java**. Il progetto è un'applicazione da riga di comando (CLI) che replica le meccaniche di gioco originali, focalizzandosi sulla precisione algoritmica e sulla gestione efficiente delle collezioni.

## 🚀 Funzionalità
* **Algoritmo di Confronto:** Logica avanzata per identificare:
  * 🟩 **Lettere corrette** nella posizione esatta.
  * 🟨 **Lettere presenti** ma in posizione errata.
  * ⬛ **Lettere assenti** nella parola segreta.
* **Gestione Dizionario:** Gestione interna del set di parole per garantire l'autonomia del software.
* **Sistema di Tentativi:** Limite di 6 tentativi con feedback immediato all'utente.

## 🛠️ Tech Stack
* **Linguaggio:** Java (JDK 8+)
* **Strutture Dati:** `ArrayList`, `List` (Java Collections Framework) per la gestione dei dizionari e dello storico dei tentativi.
* **I/O:** Gestione dei flussi di input/output per l'interazione da terminale e lettura file.

## 📂 Struttura del Progetto
Il codice è organizzato per favorire la leggibilità e la manutenibilità:
* `src/`: Contiene i file sorgente `.java`.
* `words.txt`: (Se presente) Il file dizionario utilizzato dal sistema.

## ⚙️ Compilazione ed Esecuzione
Per avviare il gioco sul tuo computer:

1. **Compila i file:**
   ```bash
   javac src/*.java
