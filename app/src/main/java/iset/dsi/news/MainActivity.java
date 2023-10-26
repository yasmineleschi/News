package iset.dsi.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements InterfaceItem {
   RecyclerView r;
   ArrayList<News> newsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = findViewById(R.id.recycleview);
        r.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter( newsList ,this,this);
        r.setAdapter(adapter);



        newsStack();
    }

    private void newsStack() {
        newsList.add(new News("News Gaza", R.drawable.gaza, "07-10-2023" , " La bande de Gaza (en arabe : قطاع غزة, Qita' Ghazzah) est une région palestinienne constituée d'une bande de terre de 41 km de long pour une largeur de 6 à 12 kilomètres, soit une superficie de 360 km², au sud de la côte orientale de la mer Méditerranée dans le bassin Levantin, au Proche-Orient. Elle tire son nom de sa principale ville, Gaza. Ce territoire est entouré par Israël et l’Égypte. En 2022, la population gazaouie est estimée à un peu plus de deux millions d'habitants3, soit environ 6.000 habitants / km². La bande de Gaza et la Cisjordanie constituent les territoires revendiqués par l'Autorité palestinienne pour l'établissement d'un État palestinien."));
        newsList.add(new News("New iphone 15", R.drawable.iphone, "20-09-2023", "L'iPhone 15 propose un écran OLED haute résolution, une caméra améliorée avec intelligence artificielle, un processeur puissant, une batterie optimisée, des fonctionnalités de sécurité avancées, un design élégant, une connectivité 5G, iOS à jour, des options de stockage généreuses, et des fonctionnalités innovantes."));
        newsList.add(new News("Education", R.drawable.educations, "15-9-2023", "L'éducation est la clé qui ouvre les portes de la connaissance et de la croissance personnelle. Elle va au-delà des salles de classe, guidant les esprits curieux vers la découverte et l'acquisition de compétences essentielles. C'est un voyage continu qui élargit les horizons, stimule la créativité et forme les fondations de la société. L'éducation n'est pas seulement un moyen d'obtenir des diplômes, mais un catalyseur qui façonne des individus capables de contribuer positivement au monde qui les entoure."));
        newsList.add(new News("Covid19", R.drawable.covid, "21-12-2019", "La COVID-19, également connue sous le nom de coronavirus, a marqué une période mondiale sans précédent. Ce virus respiratoire a entraîné des bouleversements massifs dans nos vies, engendrant des perturbations économiques, sociales et sanitaires à l'échelle mondiale. "));
        newsList.add(new News("hot topic", R.drawable.hot, "21-12-2018", "Les \"hot topics\" varient en fonction du temps, de la culture et des préoccupations sociales, mais ils ont en commun d'être des sujets brûlants et souvent passionnants pour un grand nombre de personnes.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n"));


    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this ,DetailsActivity.class);
        intent.putExtra("title",newsList.get(position).getTitle());
        intent.putExtra("image",newsList.get(position).getImage());
        intent.putExtra("date",newsList.get(position).getDate());
        intent.putExtra("description" , newsList.get(position).getDescription());
        startActivity(intent);

    }
}