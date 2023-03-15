import java.util.Random;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Vetores {
        static void geraVetor(int[] v) {
        Random random = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(v.length * 10);
        }
    }

    static void exibeVetor(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    static void bubbleSort(int[] v) {
        System.out.println("BubbleSort iniciado:");
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < v.length - i; j++) {
                if (v[j] > v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
    }

    static void insertionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = chave;

        }
    }

    static void selectionSort(int[] v) {
        for (int j = 0; j < v.length; j++) {
            int valorMinimo = j;
            for (int i = j + 1; i < v.length; i++) {
                if (v[i] < v[valorMinimo]) {
                    valorMinimo = i;
                }

            }
            int guardaValor = v[j];
            v[j] = v[valorMinimo];
            v[valorMinimo] = guardaValor;
        }
    }

    public static void main(String[] args) throws IOException{
        String user = "rodri";
        String path = "C://Users//" + user + "//Desktop//vetores//";
        new File(path).mkdirs();
        int vetores[] = {40000, 80000, 160000, 320000, 640000};
        int n_vetores = 20;
        int vetores_grandes[] = {1280000, 2560000};
        int n_vetores_grandes = 2;
        ArrayList<Long> duracoes = new ArrayList<Long>();
        for (int i = 0; i < vetores.length; i++) {
            duracoes.clear();
            System.out.println("Gerando " + vetores[i] + " vetores");
            String nome_arquivo = "bubble_" + vetores[i] + ".txt";
            File arquivo = new File(path + nome_arquivo);
            if (arquivo.exists()) {
                arquivo.delete();
            }
            FileWriter writer = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(writer);
            gravarArq.printf("Duracoes do BubbleSort para " + vetores[i] + " vetores: ");
            for (int j = 0; j < n_vetores; j++) {
                int[] v = new int[vetores[i]];
                geraVetor(v);
                Date inicio = new Date();
                bubbleSort(v);
                Date fim = new Date();
                long duracao = fim.getTime() - inicio.getTime();
                duracoes.add(duracao);
                gravarArq.printf(duracao + " ");
            }
            gravarArq.printf("\n");
            gravarArq.printf("Média das durações: " + (duracoes.stream().mapToLong(Long::longValue).sum() / duracoes.size()));
            gravarArq.close();
        }
        for (int i = 0; i < vetores_grandes.length; i++) {
            System.out.println("Gerando " + vetores_grandes[i] + " vetores");
            String nome_arquivo = "bubble_" + vetores_grandes[i] + ".txt";
            File arquivo = new File(path + nome_arquivo);
            if (arquivo.exists()) {
                arquivo.delete();
            }
            FileWriter writer = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(writer);
            gravarArq.printf("Duracoes do BubbleSort para " + vetores_grandes[i] + " vetores: ");
            for (int j = 0; j < n_vetores_grandes; j++) {
                int[] v = new int[vetores_grandes[i]];
                geraVetor(v);
                Date inicio = new Date();
                bubbleSort(v);
                Date fim = new Date();
                long duracao = fim.getTime() - inicio.getTime();
                duracoes.add(duracao);
                gravarArq.printf(duracao + " ");
            }
            gravarArq.printf("\n");
            gravarArq.printf("Média das durações: " + (duracoes.stream().mapToLong(Long::longValue).sum() / duracoes.size()));
            gravarArq.close();
        }
        for (int i = 0; i < vetores.length; i++) {
            duracoes.clear();
            System.out.println("Gerando " + vetores[i] + " vetores");
            String nome_arquivo = "insertion_" + vetores[i] + ".txt";
            File arquivo = new File(path + nome_arquivo);
            if (arquivo.exists()) {
                arquivo.delete();
            }
            FileWriter writer = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(writer);
            gravarArq.printf("Duracoes do InsertionSort para " + vetores[i] + " vetores: ");
            for (int j = 0; j < n_vetores; j++) {
                int[] v = new int[vetores[i]];
                geraVetor(v);
                Date inicio = new Date();
                insertionSort(v);
                Date fim = new Date();
                long duracao = fim.getTime() - inicio.getTime();
                duracoes.add(duracao);
                gravarArq.printf(duracao + " ");
            }
            gravarArq.printf("\n");
            gravarArq.printf("Média das durações: " + (duracoes.stream().mapToLong(Long::longValue).sum() / duracoes.size()));
            gravarArq.close();
        }
        for (int i = 0; i < vetores_grandes.length; i++) {
            System.out.println("Gerando " + vetores_grandes[i] + " vetores");
            String nome_arquivo = "insertion_" + vetores_grandes[i] + ".txt";
            File arquivo = new File(path + nome_arquivo);
            if (arquivo.exists()) {
                arquivo.delete();
            }
            FileWriter writer = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(writer);
            gravarArq.printf("Duracoes do InsertionSort para " + vetores_grandes[i] + " vetores: ");
            for (int j = 0; j < n_vetores_grandes; j++) {
                int[] v = new int[vetores_grandes[i]];
                geraVetor(v);
                Date inicio = new Date();
                insertionSort(v);
                Date fim = new Date();
                long duracao = fim.getTime() - inicio.getTime();
                duracoes.add(duracao);
                gravarArq.printf(duracao + " ");
            }
            gravarArq.printf("\n");
            gravarArq.printf("Média das durações: " + (duracoes.stream().mapToLong(Long::longValue).sum() / duracoes.size()));
            gravarArq.close();
        }
        for (int i = 0; i < vetores.length; i++) {
            duracoes.clear();
            System.out.println("Gerando " + vetores[i] + " vetores");
            String nome_arquivo = "selection_" + vetores[i] + ".txt";
            File arquivo = new File(path + nome_arquivo);
            if (arquivo.exists()) {
                arquivo.delete();
            }
            FileWriter writer = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(writer);
            gravarArq.printf("Duracoes do SelectionSort para " + vetores[i] + " vetores: ");
            for (int j = 0; j < n_vetores; j++) {
                int[] v = new int[vetores[i]];
                geraVetor(v);
                Date inicio = new Date();
                selectionSort(v);
                Date fim = new Date();
                long duracao = fim.getTime() - inicio.getTime();
                duracoes.add(duracao);
                gravarArq.printf(duracao + " ");
            }
            gravarArq.printf("\n");
            gravarArq.printf("Média das durações: " + (duracoes.stream().mapToLong(Long::longValue).sum() / duracoes.size()));
            gravarArq.close();
        }
        for (int i = 0; i < vetores_grandes.length; i++) {
            System.out.println("Gerando " + vetores_grandes[i] + " vetores");
            String nome_arquivo = "selection_" + vetores_grandes[i] + ".txt";
            File arquivo = new File(path + nome_arquivo);
            if (arquivo.exists()) {
                arquivo.delete();
            }
            FileWriter writer = new FileWriter(arquivo, true);
            PrintWriter gravarArq = new PrintWriter(writer);
            gravarArq.printf("Duracoes do SelectionSort para " + vetores_grandes[i] + " vetores: ");
            for (int j = 0; j < n_vetores_grandes; j++) {
                int[] v = new int[vetores_grandes[i]];
                geraVetor(v);
                Date inicio = new Date();
                selectionSort(v);
                Date fim = new Date();
                long duracao = fim.getTime() - inicio.getTime();
                duracoes.add(duracao);
                gravarArq.printf(duracao + " ");
            }
            gravarArq.printf("\n");
            gravarArq.printf("Média das durações: " + (duracoes.stream().mapToLong(Long::longValue).sum() / duracoes.size()));
            gravarArq.close();
        }
    }
}