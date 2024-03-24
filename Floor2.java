public class Floor2 extends Floor{
    public Floor2(int x, int y, StormveilCastle stormveilCastle)
    {
        super(x, y);
        
        PlayerTile player = new PlayerTile('P', 6, 3, stormveilCastle);
        SpawnTile spawnTile1 = new SpawnTile(1,'?', 1, 2);
        SpawnTile spawnTile2 = new SpawnTile(1,'?', 1, 4);
        SpawnTile spawnTile3 = new SpawnTile(1,'?', 3, 0);
        SpawnTile spawnTile4 = new SpawnTile(1,'?', 3, 2);
        SpawnTile spawnTile5 = new SpawnTile(1,'?', 3, 3);
        SpawnTile spawnTile6 = new SpawnTile(1,'?', 3, 4);
        SpawnTile spawnTile7 = new SpawnTile(1,'?', 3, 6);
        SpawnTile spawnTile8 = new SpawnTile(1,'?', 5, 2);
        SpawnTile spawnTile9 = new SpawnTile(1,'?', 5, 4);
        DoorTile door1 = new DoorTile('D', 0, 3, stormveilCastle);
        DoorTile door2 = new DoorTile('D', 6, 3, stormveilCastle);
        
        player.addTiletoList(tilesList);
        spawnTile1.addTiletoList(tilesList);
        spawnTile2.addTiletoList(tilesList);
        spawnTile3.addTiletoList(tilesList);
        spawnTile4.addTiletoList(tilesList);
        spawnTile5.addTiletoList(tilesList);
        spawnTile6.addTiletoList(tilesList);
        spawnTile7.addTiletoList(tilesList);
        spawnTile8.addTiletoList(tilesList);
        spawnTile9.addTiletoList(tilesList);
        door1.addTiletoList(tilesList);
        door2.addTiletoList(tilesList);

        if (player != null) {
            this.player = player;
            this.player.addTiletoList(tilesList);
        }

    }
}