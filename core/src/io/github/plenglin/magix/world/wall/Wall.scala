package io.github.plenglin.magix.world.wall

import com.badlogic.gdx.math.Vector2
import io.github.plenglin.magix.GameData
import io.github.plenglin.magix.types.{Damageable, Drawable}

/**
  * A wall. There is an instance for every wall.
  * @param i horizontal cell coordinate
  * @param j vertial cell coordinate
  */
abstract class Wall(val i: Int, val j: Int) extends Damageable with Drawable {

  val pos: Vector2 = new Vector2(i, j)
  override val targetRadius2: Float = 100

  val name: String

  override var hp: Double = maxHP

  def init(): Unit = {
    this.hp = maxHP
  }

  override def destroy(): Unit = {
    GameData.world.grid(i)(j).wall = None
  }

}
