# Goals

Providing an easy search engine for the lmu websites. Finding

* scripts
* tutorials
* courses
* tests

easier and faster.

# Webservices

To offer our data to other services, e.g. mobile Apps, mash-ups, etc,
we will provide a REST Webservices API. 

# For Developers

We use [play 2.0.3](http://www.playframework.org/), [MongoDB](http://www.playframework.org/)
and [jQuery](http://jquery.com/) to power our service. 

Just checkout the git repository and run play. Ready to go!

## Starting MongoDB

Download MongoDB (at least version 2.2.1) [here](http://www.mongodb.org/downloads) and install
it as described on the [wiki page](http://docs.mongodb.org/manual/installation/).

Start mongo in a shell with

```bash

mongod -dbpath=/path/to/mongodb/data
```

Something like this should come up

```bash

[muki@Zeus UniSearch]$ mongod -dbpath=/home/muki/.mongodb
[initandlisten] MongoDB starting : pid=5245 port=27017 dbpath=/home/muki/.mongodb 64-bit host=Zeus
[initandlisten] db version v2.2.1, pdfile version 4.5
[initandlisten] git version: d6764bf8dfe0685521b8bc7b98fd1fab8cfeb5ae
[initandlisten] build info: Linux ip-10-2-29-40 2.6.21.7-2.ec2.v1.2.fc8xen #1 SMP Fri Nov 20 17:48:28 EST 2009 x86_64 BOOST_LIB_VERSION=1_49
[initandlisten] options: { dbpath: "/home/muki/.mongodb" }
[initandlisten] journal dir=/home/muki/.mongodb/journal
[initandlisten] recover : no journal files present, no recovery needed
[initandlisten] preallocateIsFaster=true 56.8
[initandlisten] preallocateIsFaster=true 59.98
[initandlisten] preallocateIsFaster=true 59.4
[initandlisten] preallocateIsFaster check took 12.991 secs
[initandlisten] preallocating a journal file /home/muki/.mongodb/journal/prealloc.0
[initandlisten] preallocating a journal file /home/muki/.mongodb/journal/prealloc.1
[initandlisten] preallocating a journal file /home/muki/.mongodb/journal/prealloc.2
[websvr] admin web console waiting for connections on port 28017
[initandlisten] waiting for connections on port 27017
```

After that login on another shell to your mongodb with

```bash

mongo
```

On the shell you have to intatiate the db and the user with

```bash

use UniSearch
> switched to db UniSearch
db.addUser("UniSearch", "hcraeSinU")

db.system.users.find()
> { "_id" : ObjectId("50af531962ce262f6e58b6fe"), "user" : "UniSearch", "readOnly" : false, "pwd" : "a882a4422120b560bcb636a854202c80" }
```

You have created  the UniSearch test user on the db and can now run play.

## Running play

Make sure you have setup and started mongoDb correctly. Then go to the fresh UniSearch repository you checked out
and run

```bash

play run
```

go to your browser and open _localhost:9000_. Make sure you don't have any other webserver running on this port
(happens if you start more than one play instance).

## Hacking with UniSearch

If you use Eclipse as IDE is pretty straight forward. Go to console and run

```bash

play eclipsify
```

Now you can import the project with the _Import Project Wizard_ in Eclipse. As play (sbt) is compiling the
project in the background it may happen, that you have to refresh your workspace sometimes in order to remove
compiling errors.
