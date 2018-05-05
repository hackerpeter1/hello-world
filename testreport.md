#testreport
---
###Before
预先准备：  
在（3，3）上面放一个ChameleonCritter

```
   @Before
   public void setUp() throws Exception {
      world = new ActorWorld();
      j = new Jumper();
      world.add(new Location(3,3),j);
   }
```
###a、
测试内容：  
移动变色龙，看是否可以移动到一个Rock上

详解：  
我在（3，3）位置上放一个Rock，然后在（3，1）位置放一个变色龙，变色龙所超像的方向是North，我要测试的内容是变色龙是否会移动到Rock的位置。如果能够移动到那个位置，则Rock应该消失。代码如下


```
   @Test
   public void testQuestion1() {
      world.add(new Location(3,1),new Rock());
      j.move();
      boolean judge = false;
      if(world.getGrid().get(new Location(3,1)) instanceof Rock){
         judge = true;
      }
      assertTrue(judge);
   }
```
###b、判断是否可以移动出界
测试内容：  
判断是否可以移动出界

详解：  
将在（3，1）的位置放置一个变色龙，把（3，3）的变色龙放到（0，0）的边界上，移动变色龙，判断变色龙的位置是否为空。

```
@Test
   public void testQuestion2() {
      j.moveTo(new Location(0,0));
      j.move();
      boolean judge = false;
      if(j.getLocation() == null) {
         judge = true;
      }
      assertTrue(judge);
      //world.show();
   }
```