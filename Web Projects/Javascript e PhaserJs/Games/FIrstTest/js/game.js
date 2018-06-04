(function(){
    var config = {
        width:900,
        height: 550,
        type: Phaser.AUTO,
        physics:{
            default: 'arcade',
            arcade: {
                gravity: {y: 500}
            }
        },
        scene: {
            preload:preload,create:create,update:update
        }
    };
    var game = new Phaser.Game(config);
    
    function preload (){
        var background = this.load.image('background', 'assets/background.jpg');
        var player = this.load.image('player', 'assets/eye.png');
        var platform = this.load.image('ground', 'assets/platform.png');
        
        
    }
    function create(){
        this.add.image(260, 225, 'background');
        this.player = this.physics.add.sprite(450, 225, 'player').setScale(0.05);

        this.player.setBounce(0.2);
        this.player.setCollideWorldBounds(true);
        this.player.body.setGravityY(300);
        //this.player.body.setGravityX(500);
        
        var platforms = this.physics.add.staticGroup();
        platforms.create(19, 800, 'ground').refreshBody();
        
    }
    function update(){
        var speed = 260;
        cursors = this.input.keyboard.createCursorKeys();
        if(cursors.left.isDown){
            this.player.setVelocityX(-260);
            if(cursors.up.isDown){
                this.player.setVelocityY(-420);
            }
        }
        else if(cursors.right.isDown){
            this.player.setVelocityX(260);
            if(cursors.up.isDown){
                this.player.setVelocityY(-420);
            }
        }
        else if(cursors.up.isDown){
            this.player.setVelocityY(-420);
        }
        else{
            this.player.setVelocityX(0);
        }

    }
}());