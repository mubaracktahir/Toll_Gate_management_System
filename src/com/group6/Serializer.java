package com.group6;

import java.io.*;
import java.util.ArrayList;

public class Serializer {
private  BufferedReader reader;
private  BufferedWriter writer;
private  File file = new File("data//payslip");
private ArrayList<User> users ;
    public  Serializer(){

    }
    public void serialize(ArrayList<User> users){

        this.users = users;
        ArrayList<String> st = new ArrayList<>();

        for(int i = 0; i< this.users.size();i++){

            User u = users.get(i);
            st.add(u.getName()+"/"+u.getEmail()+u.getPass()+"/"+u.getMobileNumber()+"/"+u.getDateOfLastPayment()+"/"
                    +u.getTotalMoneyPayed()+"/"+u.getLastAmountPayed()+"/"+u.getIdNumber());
        }

        try {
            writer = new BufferedWriter(new FileWriter(file));
            for(int i =0 ; i < st.size() ; i++){
                writer.write(st.get(i)+"\n");
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private  void splitText(String reader) {

        String[] lines = reader.split("/");
        users = new ArrayList<>();

        User user = new User();
        user.setName(lines[0]);
        user.setEmail(lines[1]);
        user.setPass(lines[2]);
        user.setMobileNumber(lines[3]);
        user.setDateOfLastPayment(lines[4]);
        user.setTotalMoneyPayed(Double.parseDouble(lines[5]));
        user.setLastAmountPayed(Double.parseDouble(lines[6]),1);
        user.setIdNumber(lines[7]);

        users.add(user);
    }
    public void unSerialize(){


        try{


            reader = new BufferedReader(new FileReader(file));
            String line ="";
            while ( (line = reader.readLine()) != null ){
                splitText(line);
            }

        }catch (IOException e){

        }



    }

}
