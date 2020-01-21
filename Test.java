class Test
{
    private static final String [] reserved =
            { "and",
                    "begin",
                    "define",
                    "do",
                    "else",
                    "end",
                    "if",
                    "not",
                    "or",
                    "return",
                    "then",
                    "while" };

    private static int hash(String name)
    {
        return(name.charAt(0) % name.charAt(1) * name.length());
    }

    public static void main(String [] args)
    {
        for (int index = 0; index < reserved.length ; index += 1)
        {
            System.out.print("h(\"" + reserved[index] + "\") = ");
            System.out.print(hash(reserved[index]));
            System.out.println();
        }
    }
}
/*
output:
h("and") = 30
h("begin") = 34
h("define") = 40
h("do") = 23
h("else") = 37
h("end") = 26
h("if") = 18
h("not") = 1
h("or") = 2
h("return") = 32
h("then") = 35
h("while") = 3
 */