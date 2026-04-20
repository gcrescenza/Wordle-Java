# 🧩 Wordle CLI (Java)

Un'implementazione stand-alone del celebre gioco **Wordle**, sviluppata in **Java**. Il progetto è un'applicazione da riga di comando (CLI) che gestisce la logica di gioco attraverso un sistema di comandi interattivi.

## 🚀 Funzionalità e Comandi
Il software è strutturato per gestire il flusso di gioco attraverso i seguenti comandi principali:

1. **Impostazione parola segreta:** Gestione della parola da indovinare nel sistema.
2. **Mostra parola segreta:** Funzione di debug per visualizzare la parola corrente.
3. **`/gioca`:** Permette di iniziare una sessione e inserire i tentativi.
4. **Abbandona:** Consente di interrompere la partita in corso.
5. **Esci:** Chiusura sicura dell'applicazione.
6. **`/help`:** Manuale utente rapido per visualizzare i comandi disponibili.

## 🛠️ Dettagli Tecnici
* **Linguaggio:** Java (JDK 8+)
* **Algoritmo di Confronto:** Logica per fornire feedback sui tentativi (Lettera corretta/posizione errata/assente).
* **Strutture Dati:** Uso di `ArrayList` e `List` per la gestione dinamica del dizionario interno e dello storico dei tentativi.

## ⚙️ Compilazione ed Esecuzione
Dato che il progetto è auto-contenuto (senza dipendenze esterne), basta compilare i sorgenti nella cartella `src`:

1. **Compila:**
   ```bash
   javac src/*.java
