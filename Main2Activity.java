package com.example.fadla.project;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main2Activity extends AppCompatActivity {
    private static final String url ="jdbc:mysql://192.168.43.3:3306/titanic1";
    private static final String user="youssra";
    private static final String pass ="Fadlaoui1";


    private Button button;
    private TextView textView;
public String classe;
    public String sexe;
    public String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b=getIntent().getExtras();
   classe=b.getString("classe");
       age=b.getString("age");
       sexe=b.getString("sexe");
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new MyTask().execute();
            }
        });
    }
    private class MyTask extends AsyncTask<Void, Void, Void> {

        private String x;


        @Override
        protected Void doInBackground(Void... arg0) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);



                double total = 0;
                PreparedStatement sta0 = con.prepareStatement("select * from titanic_table");
                ResultSet res0 = sta0.executeQuery();
                while (res0.next()) {
                    total++;
                }
                double nbr_yes = 0;
                PreparedStatement sta1 = con.prepareStatement("select survivant  from titanic_table where survivant = \"YES\"");
                ResultSet res1 = sta1.executeQuery();
                while (res1.next()) {
                    nbr_yes++;
                }
                double a = nbr_yes / total;
                // textView.setText("This text will be placed in the textView");


                //PROBABILITé DU SURVIVANT(NO) :
                double nbr_no = 0;
                PreparedStatement sta2 = con.prepareStatement("select survivant  from titanic_table where survivant = \"NO\"");
                ResultSet res2 = sta2.executeQuery();
                while (res2.next()) {
                    nbr_no++;
                }

                double b = nbr_no / total;



                //PROBABILITE CONCERNANT L AGE

                //PROBABILITE DE L'AGE SACHANT YES
                double age_y = 0;
                if (age.equals("ADULT")) {
                    int nbr_age_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select age  from titanic_table where age = \"ADULT\" and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_age_yes++;
                    }

                    age_y = nbr_age_yes / total;


                }//age_y est la probabilité de l age ADULT sachant yes

                if (age.equals("CHILD")) {
                    int nbr_age_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select age  from titanic_table where age = \"CHILD\"  and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_age_yes++;
                    }

                    age_y = nbr_age_yes / total;


                }//age_y est la probabilité de l age CHILD sachant yes


                //PROBABILITE DE L'AGE SACHANT NO
                double age_n = 0;
                if (age.equals("ADULT")) {
                    int nbr_age_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select age  from titanic_table where age = \"ADULT\" and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_age_no++;
                    }

                    age_n = nbr_age_no / total;


                }//age_n est la probabilité de l age adulte sachant no


                if (age.equals("CHILD")) {
                    int nbr_age_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select age  from titanic_table where age = \"CHILD\"  and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_age_no++;
                    }

                    age_n = nbr_age_no / total;


                }//age_a_c est la probabilité de l age child sachant no




                //PROBABILITE CONCERNANT LA CLASSE :


                //PROBABILITE DE La CLASSE SACHANT YES
                double classe_y = 0;
                if (classe.equals("CREW")) {
                    int nbr_classe_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"CREW\" and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_yes++;
                    }

                    classe_y = nbr_classe_yes / total;


                }//classe_y est la probabilité de la classe CREW sachant YES


                if (classe.equals("3RD")) {
                    int nbr_classe_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"3RD\"  and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_yes++;
                    }

                    classe_y = nbr_classe_yes / total;


                }//classe_y est la probabilité de la classe 3RD sachant YES

                if (classe.equals("1ST")) {
                    int nbr_classe_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"1ST\"  and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_yes++;
                    }

                    classe_y = nbr_classe_yes / total;



                }//classe_y est la probabilité de la classe 1ST sachant YES

                if (classe.equals("2ND")) {
                    int nbr_classe_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"2ND\"  and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_yes++;
                    }

                    classe_y = nbr_classe_yes / total;


                }//classe_y est la probabilité de la classe 2ND sachant YES


                double classe_n = 0;

                if (classe.equals("CREW")) {
                    int nbr_classe_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"CREW\" and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_no++;
                    }

                    classe_n = nbr_classe_no / total;


                }//classe_n est la probabilité de la classe CREW sachant NO


                if (classe.equals("3RD")) {
                    int nbr_classe_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"3RD\"  and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_no++;
                    }

                    classe_n = nbr_classe_no / total;


                }//classe_n est la probabilité de la classe 3RD sachant NO

                if (classe.equals("1ST")) {
                    int nbr_classe_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"1ST\"  and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_no++;
                    }

                    classe_n = nbr_classe_no / total;


                }//classe_1_n est la probabilité de la classe 1ST sachant NO

                if (classe.equals("2ND")) {
                    int nbr_classe_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select classe  from titanic_table where classe = \"2ND\"  and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_classe_no++;
                    }

                    classe_n = nbr_classe_no / total;


                }//classe_2_n est la probabilité de la classe 1ND sachant NO




                //PROBABILITE CONCERNANT Le GENRE

                //PROBABILITE DE Le GENRE MALE SACHANT YES
                double genre_y = 0;
                if (sexe.equals("MALE")) {
                    int nbr_genre_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select sexe  from titanic_table where sexe = \"MALE\" and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_genre_yes++;
                    }

                    genre_y = nbr_genre_yes / total;


                }//genre_y est la probabilité du genre MALE sachant yes


                if (sexe.equals("FEMALE")) {
                    int nbr_genre_yes = 0;
                    PreparedStatement sta3 = con.prepareStatement("select sexe  from titanic_table where sexe = \"FEMALE\" and survivant= \"YES\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_genre_yes++;
                    }

                    genre_y = nbr_genre_yes / total;


                }//genre_y est la probabilité du genre FEMALE sachant yes


                //PROBABILITE DE Le GENRE FEMALE SACHANT NO

                double genre_n = 0;
                if (sexe.equals("FEMALE")) {
                    int nbr_genre_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select sexe  from titanic_table where sexe = \"FEMALE\" and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_genre_no++;
                    }

                    genre_n = nbr_genre_no / total;


                }//genre_n est la probabilité du genre FEMALE sachant NO


                //PROBABILITE DE Le GENRE FEMALE SACHANT NO

                if (sexe.equals("MALE")) {
                    int nbr_genre_no = 0;
                    PreparedStatement sta3 = con.prepareStatement("select sexe  from titanic_table where sexe = \"MALE\" and survivant= \"NO\"");
                    ResultSet res3 = sta3.executeQuery();
                    while (res3.next()) {
                        nbr_genre_no++;
                    }

                    genre_n = nbr_genre_no / total;


                }//genre_m_y est la probabilité du genre MALE sachant NO


                double probabilite_YES = a * age_y * classe_y * genre_y;

                double probabilite_NO = b * age_n * classe_n * genre_n;


                if (probabilite_YES >= probabilite_NO) {
                    x="SURVIVANT";
                }

                if (probabilite_YES < probabilite_NO) {
                    x="NON SURVIVANT";
                }



                // x = rs.getString(1);
            } catch (Exception e) {
                x = e.getMessage();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            textView.setText(x);
            super.onPostExecute(aVoid);
        }
    }
}

