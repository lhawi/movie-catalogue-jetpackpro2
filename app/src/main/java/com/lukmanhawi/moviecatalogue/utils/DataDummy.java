package com.lukmanhawi.moviecatalogue.utils;

import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.data.source.remote.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {
    public static List<MovieEntity> generateDummyMovies() {

        List<MovieEntity> movies = new ArrayList<>();

        movies.add(new MovieEntity(
                "332562",
                "A Star Is Born",
                "2018-04-25",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "7.5",
                "https://image.tmdb.org/t/p/w400/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"));

        movies.add(new MovieEntity(
                "399579",
                "Alita: Battle Angel",
                "2019-01-31",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "6.9",
                "https://image.tmdb.org/t/p/w400/xRWht48C2V8XNfzvPehyClOvDni.jpg"));

        movies.add(new MovieEntity(
                "297802",
                "Aquaman",
                "2018-12-07",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "6.8",
                "https://image.tmdb.org/t/p/w400/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"));

        movies.add(new MovieEntity(
                "424694",
                "Bohemian Rhapsody",
                "2018-10-24",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "8.0",
                "https://image.tmdb.org/t/p/w400/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"));

        movies.add(new MovieEntity(
                "438650",
                "Cold Pursuit",
                "2019-02-07",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "5.4",
                "https://image.tmdb.org/t/p/w400/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"));

        movies.add(new MovieEntity(
                "480530",
                "Creed II",
                "2018-11-21",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "6.8",
                "https://image.tmdb.org/t/p/w400/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"));

        movies.add(new MovieEntity(
                "338952",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018-11-14",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "6.8",
                "https://image.tmdb.org/t/p/w400/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"));

        movies.add(new MovieEntity(
                "450465",
                "Glass",
                "2019-01-16",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "6.5",
                "https://image.tmdb.org/t/p/w400/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"));

        movies.add(new MovieEntity(
                "166428",
                "How to Train Your Dragon: The Hidden World",
                "2019-01-03",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "7.7",
                "https://image.tmdb.org/t/p/w400/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"));

        movies.add(new MovieEntity(
                "299536",
                "Avengers: Infinity War",
                "2018-10-03",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "8.3",
                "https://image.tmdb.org/t/p/w400/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));

        return movies;
    }

        public static MovieEntity generateDummyMoviesById(String id) {
            MovieEntity movieResponse = null;
            List<MovieEntity> movies = generateDummyMovies();

            for (MovieEntity response : movies){
                if (response.getMovieId().equals(id)){
                    movieResponse = response;
                }
            }

            return movieResponse;

    }

    public static List<TvEntity> generateDummyTv() {

        List<TvEntity> tvshows = new ArrayList<>();

        tvshows.add(new TvEntity(
                "1412",
                "Arrow",
                "2012-10-10",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "5.9",
                "https://image.tmdb.org/t/p/w400/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"));

        tvshows.add(new TvEntity(
                "79501",
                "Doom Patrol",
                "2019-02-15",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "6.5",
                "https://image.tmdb.org/t/p/w400/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg"));

        tvshows.add(new TvEntity(
                "12609",
                "Dragon Ball",
                "1986-02-26",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "7.1",
                "https://image.tmdb.org/t/p/w400/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg"));

        tvshows.add(new TvEntity(
                "46261",
                "Fairy Tail",
                "2009-10-12",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "6.6",
                "https://image.tmdb.org/t/p/w400/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg"));

        tvshows.add(new TvEntity(
                "1434",
                "Family Guy",
                "1999-01-31",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "6.5",
                "https://image.tmdb.org/t/p/w400/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg"));

        tvshows.add(new TvEntity(
                "60735",
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "6.8",
                "https://image.tmdb.org/t/p/w400/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"));

        tvshows.add(new TvEntity(
                "1399",
                "Game of Thrones",
                "2011-04-17",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "8.2",
                "https://image.tmdb.org/t/p/w400/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"));

        tvshows.add(new TvEntity(
                "60708",
                "Gotham",
                "2014-09-22",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "6.9",
                "https://image.tmdb.org/t/p/w400/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"));

        tvshows.add(new TvEntity(
                "1416",
                "Grey's Anatomy",
                "2005-03-27",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "6.5",
                "https://image.tmdb.org/t/p/w400/jnsvc7gCKocXnrTXF6p03cICTWb.jpg"));

        tvshows.add(new TvEntity(
                "54155",
                "Hanna",
                "2019-03-28",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "6.8",
                "https://image.tmdb.org/t/p/w400/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg"));

        return tvshows;
    }

    public static TvEntity generateDummyTvShowsById(String id) {
        TvEntity tvshowResponse = null;
        List<TvEntity> tv = generateDummyTv();

        for (TvEntity response : tv){
            if (response.getTvId().equals(id)){
                tvshowResponse = response;
            }
        }

        return tvshowResponse;

    }
}
