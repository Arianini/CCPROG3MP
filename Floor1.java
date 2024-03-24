public class Floor1 extends Floor{

    private GameLobby gamelobby;
    private BossTile bossTile;

    public Floor1(int x, int y, StormveilCastle stormveilCastle) {
        super(x, y); 

        PlayerTile player = new PlayerTile('P', 6, 1, stormveilCastle);
        FastTravelTile fastTravel = new FastTravelTile('F', 5, 1, true, stormveilCastle, gamelobby, bossTile);
        SpawnTile spawnTile1 = new SpawnTile(1, '?', 1, 0);
        SpawnTile spawnTile2 = new SpawnTile(1, '?', 1, 2);
        DoorTile door = new DoorTile('D', 0, 1, stormveilCastle);
        
        fastTravel.addTiletoList(tilesList);
        player.addTiletoList(tilesList);
        spawnTile1.addTiletoList(tilesList);
        spawnTile2.addTiletoList(tilesList);
        door.addTiletoList(tilesList);

        if (player != null) {
            this.player = player;
            this.player.addTiletoList(tilesList);
        }
    }
}