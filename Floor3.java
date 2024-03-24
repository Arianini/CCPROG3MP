public class Floor3 extends Floor{

    private GameLobby gamelobby;
    private BossTile bossTile;

    public Floor3(int x, int y, StormveilCastle stormveilCastle)
    {
        super(x, y);

        PlayerTile player = new PlayerTile('P', 6, 2, stormveilCastle);
        FastTravelTile fastTravel = new FastTravelTile('F', 0, 2, true, stormveilCastle, gamelobby, bossTile);
        BossTile bossTile = new BossTile('B', 3, 2);
        DoorTile door = new DoorTile('D', 6, 2, stormveilCastle);
        
        fastTravel.addTiletoList(tilesList);
        player.addTiletoList(tilesList);
        bossTile.addTiletoList(tilesList);
        door.addTiletoList(tilesList);

        if (player != null) {
            this.player = player;
            this.player.addTiletoList(tilesList);
        }
    }
}
