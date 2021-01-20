package com.luots.caribbean2d.sprites

import com.luots.caribbean2d.sprites.Sprites.__DEFAULT_TILE_SIZE__
import com.luots.caribbean2d.utils.{Double_For_Achieve, Tool_For_Java}

import java.awt.image.BufferedImage

/* ************************************************************************
 *
 * Copyright (C) 2020 caribbeansea All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ************************************************************************/

/*
 * Creates on 2021/1/5.
 */

/**
 * Sprites是个用于角色、道具、炮弹以及其他2D游戏元素的二维图形对象。2D游戏的图像部分主要是图片的处理，
 * 图片通常称为Sprite精灵。
 * <p>
 * 为了提高2d游戏的效率，会将图片资源拼接成一张大图，在游戏运行的时候在将这张图的莫一部分读取出来作为Sprite显示在屏幕上
 * 该图形是基于Texture2D得到的图像。Sprite类主要识别图像的一部分用于特定的精灵。
 * <p>
 * 此类通过游戏对象上实现的 Game_Renderer 的组件应用并实际显示该图像。
 *
 * @param sprite_sheet 完整的精灵图片
 * @param rect_w       矩形宽度
 * @param rect_h       矩形高度
 * @author tiansheng
 */
class Sprites(private val sprite_sheet: BufferedImage, val rect_w: Int, val rect_h: Int) {

  /**
   * 精灵图片宽度
   */
  val sprite_w: Int = sprite_sheet.getWidth() / rect_w

  /**
   * 精灵图片高度®
   */
  val sprite_h: Int = sprite_sheet.getHeight() / rect_h

  /**
   * 精灵动画数组
   */
  val sprite_arr: Array[Array[BufferedImage]] = {
    /* 生成一个二维数组 */
    val sprite_arr = Array.ofDim[BufferedImage](sprite_h, sprite_w)

    Tool_For_Java.__Double_For__(sprite_h, sprite_w, new Double_For_Achieve() {
      override def achieve(x: Int, y: Int): Unit = {
        sprite_arr(x)(y) = sprite_sheet.getSubimage(y * rect_h, x * rect_w, rect_w, rect_h)
      }
    })

    sprite_arr /* return */
  }

  /**
   * 构造器
   *
   * @param sprite_sheet 完整的精灵图片
   */
  def this(sprite_sheet: BufferedImage) = this(sprite_sheet, __DEFAULT_TILE_SIZE__, __DEFAULT_TILE_SIZE__)

  /**
   * 获取子精灵图
   *
   * @param x 初始X坐标
   * @param y 初始Y坐标
   * @return 子精灵
   */
  def get_subsprites(x: Int, y: Int): BufferedImage = sprite_arr(x)(y)

}

object Sprites {
  val __DEFAULT_TILE_SIZE__ : Int = 32
}

