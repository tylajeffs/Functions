import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //set variables
        String line1;
        String line2;
        String line3;
        Boolean function = true;
        Boolean onto = true;
        Boolean one2one = true;

        //create scanner to read file
        Scanner s = new Scanner(System.in);


        //store lines into their variables
        line1 = s.nextLine();
        line2 = s.nextLine();
        line3 = s.nextLine();


        //close scanner
        s.close();


        //split the lines and store in array
        String[] domain = line1.split(" ");

        String[] coDomain = line2.split(" ");

        String[] relationPairs = line3.split(" ");






        //create parallel array lists for the ordered pairs
        ArrayList<Object> inputs = new ArrayList<Object>();
        ArrayList<Object> outputs = new ArrayList<Object>();


        //store the inputs and outputs in the lists
        for(int i = 0; i < relationPairs.length; i += 2)
        {
            //add the first element to the inputs
            inputs.add(relationPairs[i]);

            //add the second element to the outputs
            outputs.add(relationPairs[i+1]);

        }









        //check if it is a function
        int counter = 0;

        for(Object o: inputs)
        {
            for(Object obj: inputs)
            {
                if(o.equals(obj))
                {
                    counter++;
                }
                if(counter >= 2)
                {
                    //if there are two inputs that are the same, it isn't a function
                    function = false;
                }
            }
            //reset the counter back to 0
            counter = 0;
        }




        //check if it is onto
        //onto functions have the same range and codomain - every element in codomain is mapped to
        if(outputs.size() < coDomain.length)
        {
            onto = false;
        }





        //check if it is one-to-one
        //one-to-one functions have only one input for each output
        int count = 0;

        //loop through outputs to see if there is just one of each
        for(Object o: outputs)
        {
            for(Object obj: outputs)
            {
                //if they are the same, increase count
                if(o.equals(obj))
                {
                    count++;
                }
                if(count >= 2)
                {
                    //if there are two of the same outputs, it's not one-to-one
                    one2one = false;
                }
            }
            //reset the counter back to 0
            count = 0;
        }
















        //print out the domain
        System.out.print("DOMAIN: { ");
        for(int i = 0; i < domain.length; i++)
        {
            //check if it's the last one
            if( i == domain.length - 1)
            {
                //print with a space and closing brace
                System.out.print(domain[i] + " }\n");
            }
            else
            {
                //print with a comma and space
                System.out.print(domain[i] + ", ");
            }

        }



        //print out the co-domain
        System.out.print("CODOMAIN: { ");
        for(int i = 0; i < coDomain.length; i++)
        {
            //check if it's the last one
            if( i == coDomain.length - 1)
            {
                //print with a space and closing brace
                System.out.print(coDomain[i] + " }\n");
            }
            else
            {
                //print with a comma and space
                System.out.print(coDomain[i] + ", ");
            }

        }



        //print out the relation
        System.out.print("RELATION: { ");
        for(int i = 0; i < relationPairs.length; i += 2)
        {
            //check if it's the last one
            if( i == relationPairs.length - 2)
            {
                //print with a space and closing brace
                System.out.print("(" + relationPairs[i] + "," + relationPairs[i+1] + ") }\n");
            }
            else
            {
                //print with a comma and space
                System.out.print("(" + relationPairs[i] + "," + relationPairs[i+1] + "), ");
            }

        }



        //print out if it is a function or not
        if(function)
        {
            System.out.println("This is a function.");
        }
        else if(!function)
        {
            System.out.println("This is *NOT* a function.");
        }





        //print out if onto
        if(onto)
        {
            System.out.println("It is onto.");
        }
        else if(!onto)
        {
            System.out.println("It is *NOT* onto.");
        }




        //print out if one to one
        if(one2one)
        {
            System.out.println("It is one-to-one.");
        }
        else if(!one2one)
        {
            System.out.println("It is *NOT* one-to-one.");
        }




        //print out if bijection
        if(onto && one2one)
        {
            System.out.println("It is a bijection.");
        }
        else if(!onto || ! one2one)
        {
            System.out.println("It is *NOT* a bijection.");
        }



    }
}
