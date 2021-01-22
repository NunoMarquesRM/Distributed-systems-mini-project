# Distributed systems mini project
     Course unit: Distributed Systems - Server that manages a book exchange program

(In portuguese)

    Suponha um servidor que faz a gestão de um programa de troca de livros. Os
utilizadores podem oferecer livros, e levantar livros. O servidor contém uma lista de
livros (suponha que apenas é guardado o nome do livro num objeto do tipo
ArrayList<String> ). Não precisa de implementar persistência de dados.
Estão disponíveis 3 opções: Oferecer livro; Levantar livro; Consultar livros existentes.
 
 
    Oferecer um livro é: - o cliente envia o nome do livro e o IP da sua máquina, o servidor
insere o livro na lista e dá a resposta que será detalhada mais abaixo. O IP, não deve ser
introduzido pelo utilizador, mas sim obtido de forma automática pelo processo cliente.


    Levantar um livro é: - dado o nome do livro pelo cliente, o servidor deve removê-lo da
lista caso ele conste da lista.


Consultar livros é: - o cliente obter do servidor a lista dos livros existentes.

    Pretende-se uma aplicação com um servidor multi-threaded em que o cliente e o servidor
comunicam por Sockets TCP. Para cada ligação do cliente, este pode escolher várias
opções até decidir terminar.

    Para incentivar a oferta de livros é realizado um sorteio, cujo prémio é um cheque livro,
entre os clientes que oferecem livros.

    Mas, nem todos os clientes têm acesso ao sorteio. Para decidir que doadores têm acesso
ao sorteio, terá que numerar sequencialmente as doações. Isto é, a primeira vez que a
opção “Oferecer livro” é executada, será a doação 1, a segunda vez que é executada será
a doação 2, e assim por diante, independentemente se é o mesmo cliente a escolher a
opção ou outro qualquer. Os clientes a participar no sorteio serão aqueles que oferecem
os livros cuja doação tem um número que é múltiplo de Y, (com Y = último dígito do seu
número de aluno + 7). Por exemplo se o último dígito do seu número de aluno é 0, as
doações que tiverem número 7, 14 21, 28, …terão acesso ao sorteio. Se o último dígito do
seu número de aluno é 1, as doações que tiverem número 8, 16, 24, 32, …, terão acesso
ao sorteio e assim por diante.

    Assim, cada vez que é feita uma operação de oferta cujo número de ordem é múltiplo de
Y, o cliente receberá uma mensagem, "Parabéns, “xxx” tem um bilhete para o sorteio",
Se o número da operação de oferta não for múltiplo de Y o cliente receberá a mensagem
“Olá “xxx”, obrigada pelo livro”.

    Notas: “xxx” é o IP do processo cliente. O servidor deve conhecer o seu número de
aluno.
