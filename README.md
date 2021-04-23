# GodsEyeGeyserMC now with maven
This plugin makes GodsEye Completely ignore BedRock players

# Contributors:
 - Pikaronga#6450

# API
```java
public void onBypassCancel(GodsEyeGeyserBypassEvent event){
 event.setCancelled(true);
}
```
```java
public void onBypassMessage(GodsEyeGeyserBypassEvent event){
 Player player = event.getPlayer();
 player.sendMessage("Hello bedrock player");
}
```
