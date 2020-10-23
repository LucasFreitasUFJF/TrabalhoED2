# <p align="center">

<img src="https://is2-ssl.mzstatic.com/image/thumb/Purple124/v4/8d/24/12/8d2412ff-7385-cc81-d0c8-6bd01bf3d3fd/AppIcon-0-0-1x_U007emarketing-0-0-0-10-0-0-sRGB-0-0-0-GLES2_U002c0-512MB-85-220-0-0.png/1200x630wa.png">

</p>

### Tópicos

  

[Básico para Execução](#básico-para-a-execução-do-programa)

[Instruções](#instruções-de-uso)

[Classes](#classes-do-projeto)


# Estrutura de dados 2

## Básico para a execução do programa
**1.** Java JDK 8
 https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html


**2.** Clone ou baixe o repositório:

```bash
$ git clone https://github.com/LucasFreitasUFJF/TrabalhoED2
```
**3.** É necessário o download do dataset encontrado no link https://drive.google.com/file/d/1Wg6pAx5sjdSS8M-9UNIEQPQiy_dS4Fzb/view?usp=sharing, após o download, extraia e coloque o arquivo "dataset_simp_sem_descricao.csv" na pasta de Entradas.

**4.** É possivel executar usando uma IDE, como NetBeans, basta abrir a pasta como projeto.

**5.** Para executar por linha de comando abre o terminal e digite:

```bash
$ java -jar TrabalhoED2.jar
```

## Instruções de uso
Ao executar programa ele fará o pré-carregamento de livros na memória e em seguinte menu será mostrado:
```
Pré-carregando livros em memória!

Escolha sua opção:
1 - Parte 1
2 - Parte 2
3 - Parte 3
0 - Salvar e Sair
```
Por enquanto a unica opção válida é a 1(Primeira parte do trabalho), após a execução, digite a opção 0 para salvar os dados em um arquivo de texto e sair.

### Parte 1
Os resultados de cada parte são armazenados em `Saídas`. O arquivo está divida pelo tipo de ordenação, seguida de uma divisao por Tamnho, Tempo(ms), cópias e comparações

```
---Parte 1---
Executa as ordenações 5 vezes para cada N.
```
## Classes do projeto 

| Classe         | Descrição   |
| -------------- | ----------- |
| Escrita          | Escrita dos resultados no arquivo de saida                                                                      |
| Leitura  | Leitura do dataset                                           |
| Autor    | Definição da classe referentes aos autores dos livros                              |
| Categoria        | Definição da classe responsavel pela categoria dos livros                                                                              |
| Livro        | Definição dos livros                                                                             |
| Dados        | Classe para armazenar os dados do dataset na memoria                                                                              |
| Metrica        | Processamento dos dados de tempo, comparação, cópias                                                                              |
| OpçõesMenu        | Separa as execuções do programa pelas opções inseridas no menu                                                                              |
| HeapSort       | Implementação da ordenação do tipo Heap Sort                                  |
| InsertionSort  | Implementação da ordenação do tipo Insertion Sort                             |
| MergeSort      | Implementação da ordenação do tipo Merge Sort                                 |
| ShellSort       | Implementação da ordenação do tipo Tree Sort                                  |
| QuickSort      | Implementação dos tipos de ordenação Quick Sort: Recursivo, Mediana, Inserção |
