package com.luots.caribbean2d.defined_type

trait Defined_Type {

  type Error = Throwable
  type Bool = Boolean
  type Y = true
  type N = false

  type typeof = Unit
  /* 类型判断 */
  type sizeof = Unit /* 对象大小计算 */

  type Un_Int = Type_UnInt

}
