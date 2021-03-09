package perez.alfredo.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_catalago_peliculas.*
import kotlinx.android.synthetic.main.pelicula.view.*

class CatalagoPeliculasActivity : AppCompatActivity() {
    var peliculas = ArrayList<Pelicula>();
    var series = ArrayList<Pelicula>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalago_peliculas)

        agregarPeliculas();
        agregarSeries();

        var gridviewSeries: GridView = findViewById(R.id.gridviewSeries) as GridView;
        var adapter2: CatalagoPeliculasActivity.PeliculaAdapter = CatalagoPeliculasActivity.PeliculaAdapter(this, series);
        gridviewSeries.adapter = adapter2;

        var gridviewPeliculas: GridView = findViewById(R.id.gridviewPeliculas) as GridView;
        var adapter:PeliculaAdapter = PeliculaAdapter(this, peliculas);
        gridviewPeliculas.adapter = adapter;

    }

    fun agregarPeliculas(){
        peliculas.add(Pelicula("1917",R.drawable.a1917,R.drawable.a1917header,"British trenches somewhere in France. World war has been going on for the third year, heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy."))
        peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6,R.drawable.headerbighero6,"When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called&quot;Big Hero 6.&quot;"))
        peliculas.add(Pelicula("Leap year",R.drawable.leapyear,R.drawable.leapyearheader,"A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula("MIB",R.drawable.mib,R.drawable.mibheader,"Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency&#39;s finest men only going by the name &quot;K&quot; (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the &quot;Bug&quot; race. He takes the body of a farmer (Vincent D&#39;Onofrio) and heads to New York. He is searching for a super energy source called &quot;The Galaxy&quot;. Now, Agents J and K must stop the bug before it can escape with the galaxy."))
        peliculas.add(Pelicula("Toy Story",R.drawable.toystory,R.drawable.toystoryheader,"Toy Story is about the &#39;secret life of toys&#39; when people are not around. When Buzz Lightyear, a space-ranger, takes Woody&#39;s place as Andy&#39;s favorite toy, Woody doesn&#39;t like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."))
        peliculas.add(Pelicula("Inception",R.drawable.inception,R.drawable.inceptionheader,"Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb&#39;s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))

    }

    fun agregarSeries(){
        series.add(Pelicula("Dr. House",R.drawable.drhouse, R.drawable.househeader, "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try to cure complex and rare diseases from very ill ordinary people in the United States of America."));
        series.add(Pelicula("Smallville",R.drawable.smallville,R.drawable.smallvilleheader,"The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic egresses in the past. They say he&#39;s either too fast or has a penchant for finding trouble. He was found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted Clark&#39;s friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for Clark&#39;s outlandish valor. However, on the face of it, Clark just seems a normal boy who&#39;s slightly more secretive than usual."));
        series.add(Pelicula("Dr. Who",R.drawable.drwho,R.drawable.drwhoheader,"Traveling across time and space, the immortal time-lord known as &#39;The Doctor&#39; travels across the universe with his many companions and his loyal shape-shifting space-ship: The TARDIS. The Doctor faces many threats across many generations: from The Daleks, The Cybermen and his time-lord adversary The Master to the sinister Davros, creator of The Daleks."))
        series.add(Pelicula("Bones",R.drawable.bones,R.drawable.bonesheader,"Dr. Temperance Brennan is a brilliant, but lonely, anthropologist whom is approached by an ambitious FBI agent, named Seely Booth, to help the bureau solve a series of unsolved crimes by identifying the long-dead bodies of missing persons by their bone structure. But both Agent Booth and Dr. Brennan and her team come up again a variety of interference from red tape, corruption, and local noncooperation."))
        series.add(Pelicula("Suits",R.drawable.suits,R.drawable.suitsheader,"While running from a drug deal gone bad, brilliant young college dropout Mike Ross slips into a job interview with one of New York City&#39;s best legal closers, Harvey Specter. Tired of cookie-cutter law-school grads, Harvey takes a gamble by hiring Mike on the spot after recognizing his raw talent and photographic memory. Mike and Harvey are a winning team. Although Mike is a genius, he still has a lot to learn about law; and while Harvey might seem like an emotionless, cold-blooded shark, Mike&#39;s sympathy and concern for their cases and clients will help remind Harvey why he went into law in the first place. Mike&#39;s other allies in the office include the firm&#39;s best paralegal Rachel and Harvey&#39;s no-nonsense assistant Donna. Proving to be an irrepressible duo and invaluable to the practice, Mike and Harvey must keep their secret from everyone including managing partner Jessica and Harvey&#39;s archnemesis Louis, who seems intent on making Mike&#39;s life as difficult as possible."))
        series.add(Pelicula("Friends",R.drawable.friends,R.drawable.friendsheader,"Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay are six 20 something year-olds, living off of one another in the heart of New York City. Over the course of ten years, this average group of buddies goes through massive mayhem, family trouble, past and future romances, fights, laughs, tears and surprises as they learn what it really means to be a friend."))
    }

    public class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Pelicula>();
        var context: Context?= null;

        constructor(context: Context, peliculas: ArrayList<Pelicula>){
            this.context = context;
            this.peliculas = peliculas
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pelicula = peliculas[position];
            var inflator = LayoutInflater.from(context);
            var vista = inflator.inflate(R.layout.pelicula, null);

            var img = vista.findViewById(R.id.imagen) as ImageView;
            var name = vista.findViewById(R.id.titulo) as TextView;

            img.setImageResource(pelicula.imagen);
            name.setText(pelicula.titulo);

            vista.imagen.setOnClickListener {
                var intent = Intent(context, DetallePelicula::class.java);
                intent.putExtra("titulo",pelicula.titulo);
                intent.putExtra("sinopsis",pelicula.sinopsis);
                intent.putExtra("imagen",pelicula.imagen);
                intent.putExtra("header",pelicula.header);
                context!!.startActivity(intent);
            }
            return vista
        }

        override fun getItem(position: Int): Any {
            return peliculas[position];
        }

        override fun getItemId(position: Int): Long {
            return position.toLong();
        }

        override fun getCount(): Int {
            return peliculas.size;
        }


    }
}