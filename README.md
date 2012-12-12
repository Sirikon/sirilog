![SiriLog logo](http://dev.bukkit.org/media/images/48/911/SiriLog.png)

__SiriLog__ is a system event log really simple and easy for administrators who need to record everything that happens.

__Tested on Tekkit!__

But... what exactly does SiriLog?
=================================
SiriLog records events on your server, and whenever SiriLog record 15 events, save them in a file called "sirilog.log" in "plugins/SiriLog" with the time and date it was recorded, the coordinates and world of the event, the user that caused it and the affected block type.</p>

__Example log line:__
> [2012/11/25 10:32:44] Sirikon broke COBBLESTONE X=40 Y=20 Z=60 world

In the future will be able to save the data in a MySQL database.

Features
========
SiriLog can __log__:

- Block placing/breaking
- Door/Lever/Button Interactions
- Chest opennings
- Explosions (TNT, Creepers...)

Commands
========
- __/sl__: Shows the SiriLog's version
- __/sl queue__: Shows how many changes are on queue for save
- __/sl save__: Save the actual queue

Permissions
===========
- __sirilog.info__: Allow to use "/sl", "/sl queue" and "/sl save"

Configuration
=============
Not yet...

This plugin is quite short
==========================
I know, and I'm working on it to make it a good plugin.

Understand me, it's my first plugin :) ...

[SiriLog on Github](https://github.com/Sirikon/sirilog)