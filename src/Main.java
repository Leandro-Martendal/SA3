import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Person> students = new ArrayList<>();
    static int nmatricula;

    public static void main(String[] args) {

        boolean exit = true;
        while (exit){

            //Abaixo, menu - Below, menu
            System.out.println("------------------------------------ SHOESHAPPY ------------------------------------ ");
            System.out.println("Insira a opção desejada:");
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Buscar cliente");
            System.out.println("3 - Remover cliente");
            System.out.println("4 - Editar cliente");
            System.out.println("5 - Exibir todos os clientes");
            System.out.println("6 - Quantidade de clientes");
            System.out.println("7 - Encerrar");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    signStudent(students);
                    break;
                case 2:
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudent(students, nameToFind);
                    break;

                case 3:
                    delStudent();
                    break;

                case 4:
                    editStudent();
                    break;

                case 5:
                    listStudent();
                    break;

                case 6:
                    genderStudent();
                    break;

                case 7:
                    exit = false;
                    break;
            }
        }
    }

    //Cadastrar estudante - Register student
    private static void signStudent(List<Person> students){
        Person student = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo/razão social do cliente:");
        student.name = scanner.nextLine();
        System.out.println("Qual o tipo do cliente? (CPF/CNPJ)");
        student.sexo = scanner.next();
        System.out.println("Qual o CPF/CNPJ do cliente?");
        student.idade = Long.parseLong(scanner.next());

        //Algum BUG, está exigindo a realização do Scan novamente
        scanner.nextLine();

        System.out.println("Digite o endereço completo do cliente:");
        student.endereco = scanner.nextLine();
        student.matricula = nmatricula++ ;
        students.add(student);
        System.out.println("Obrigado por digitar os dados do " + student.name + ".");
    }

    //Buscar estudante - Search student
    private static Integer findStudent(List<Person> students, String studentName){
        boolean finding = true;
        Integer position = null;

        for(int count = 0; count < students.size(); count++){
            Person student = students.get(count);
            if(student.name.equals(studentName)){
                position = count;

                System.out.println("Consegui encontrar o " + studentName);
                finding = false;
            }
        }
        if(finding) {
            System.out.println("Não foi possível encontrar o " + studentName + ".");
        }
        return position;
    }
    //Deletar estudante - Remove student
    private static void delStudent() {
        System.out.println("Qual cliente gostaria de remover?");
        String name = scanner.next();
        Integer position = findStudent(students, name);
        if(position != null){
            students.remove(position.intValue());
            System.out.println("Cliente removido com sucesso.");
        }
    }

    //Editar estudante - Edit student
    private static void editStudent(){
        System.out.println("Qual cliente que deseja editar?");
        String name = scanner.next();
        Integer position = findStudent(students, name);
        if(position != null){
            Person p1 = students.get(position.intValue());
            System.out.println("Qual é o novo nome?");
            name = scanner.next();
            //studants.get(position.intValue()).name = name;
            p1.name = name;
        }
    }

    //Exibir todos os estudantes - Show all students
    private static void listStudent(){
        for(int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).name + ", matrícula " + students.get(i).matricula + ", " + students.get(i).sexo +
            " nº " + students.get(i).idade + ", endereço: " + students.get(i).endereco);
        }
    }

    //Exibe a quantidade de alunos por sexo e o total - Displays the number of students by gender and the total
    private static void genderStudent(){
        int m = 0;
        int f = 0;
        int t = 0;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).sexo.equals("CPF")){
                m++;
                t++;
            }else{
                f++;
                t++;
            }
        }
        if(m >= 2){
            System.out.println("Temos " + m + " clientes CPF");
        } else if( m == 1){
            System.out.println("Temos " + m + " cliente CPF");
        } else{
            System.out.println("Não temos clientes CPF");
        }
        if(f >= 2){
            System.out.println("Temos " + f + " clientes CNPJ");
        } else if( f == 1){
            System.out.println("Temos " + f + " CNPJ");
        } else{
            System.out.println("Não temos clientes CNPJ");
        }
        if(t >= 2){
            System.out.println("Temos um total de " + t + " clientes");
        } else if( t == 1){
            System.out.println("Temos um cliente");
        } else{
            System.out.println("Não temos clientes");
        }
    }
}