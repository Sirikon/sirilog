![SiriLog logo](http://dev.bukkit.org/media/images/48/911/SiriLog.png)

__SiriLog__ is a system event log really simple and easy for administrators who need to record everything that happens.

I'm trying to develop this plugin with Mods like IndustrialCraft, BuildCraft or RedPower in mind, so this plugin maybe will not record all the events in this mods, but at least will record breaking/placing mod blocks and will not break like happens with other plugins.

But... what exactly does SiriLog?
=================================
SiriLog records events on your server, and whenever SiriLog record 15 events, save them in a file called "sirilog.log" in "plugins/SiriLog" with the time and date it was recorded, the coordinates and world of the event, the user that caused it and the affected block type.

In the future will be able to save the data in a MySQL database.

Features
========
SiriLog can __log__:

- Block placing/breaking
- Door/Lever/Button Interactions
- Chest opennings
- Explosions (TNT, Creepers...)

Log Examples
============

__Block Placing__
> [2012/11/25 10:32:44] User put COBBLESTONE X=60 Y=20 Z=60 world

__Block breaking__
> [2012/11/25 10:32:44] Grieffer broke SMOOTH_BRICK X=3 Y=4 Z=500 world_nether

__Door Interactions__
> [2012/11/25 10:32:44] User used WOODEN_DOOR X=300 Y=450 Z=12 world

__Chest Oppening__
> [2012/11/25 10:32:44] Thief opened DOUBLE_CHEST X=233 Y=424 Z=125 world

__Explosions__
> [2012/11/25 10:32:44] \[ENVIRONMENT\] explosionof PRIMED_TNT X=1 Y=2 Z=3 world

Commands
========
- __/sl__: Shows the SiriLog's version
- __/sl queue__: Shows how many changes are on queue for save
- __/sl save__: Save the actual queue
- __/sl reload__: Reload configuration without reloading plugin or server

Permissions
===========
- __sirilog.info__: Allow to use "/sl", "/sl queue" and "/sl save"

Configuration
=============

__Default config.yml file:__

    recordings:
        showlogsaved: false        <--- Show a message in server's console saying "X logs saved"
        savelimit: 30              <--- How many logs wait for autosave
    log:
        breakblock: true           <--- Log block breaking
        placeblock: true           <--- Log block placing
        openchest: true            <--- Log chest openning
        explosions: true           <--- Log explosions
        playerinteractions: true   <--- Log doors/levers/buttons interactions

This plugin is quite short
==========================
I know, and I'm working on it to make it a good plugin.

Understand me, it's my first plugin :) ...

[SiriLog on Github](https://github.com/Sirikon/sirilog)
