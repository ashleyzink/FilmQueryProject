### Film Query Project
This app lets you sort through all of the film information we have on file. If you have the film id, Great! We can help you find the movie you're looking for, and all of the actors in that film. If you can only remember a keyword for the movie, that's fine too. We can help you find that movie, and maybe more that you may be interested in!
## Topics
* ORM(Object-RelationalMapping)
* ERDiagram
* MySQL Database
* JDBC
## Lessons Learned
Initially I tried to put my queries in a try with resources. It turns out that my IDE wasn't a big fan of that and I had to go back, put it in a normal try/catch block, and close out each of the pieces. It wasn't a huge deal as it's a smaller project, but had I done it on a larger scale, it might have taken a bit more effort to fix. I also got a good amount of practice with the DAO. The keyword query in the DAO was definitely the hardest. Because I was bringing in information from more than one table, and more than one column on the film table, I had to play around for a while to get it just right. Overall it was a pretty fun project, and I have a sneaking suspicion that it'll be very helpful come midterm project time.
## How to Run
Upon starting the program you'll be greeted with a menu prompting you to make a selection on how you'd like to search for your film. If you have the Film Id press 1, if you want to search by keyword press 2.
After that you must have the correct film id or will take you to the beginning of the menu again. Once you are done searching for films, you can exit by pressing 3.
