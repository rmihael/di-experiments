package com.experiments

import scalaz._

package object di {
  type Configured[+A] = Reader[Context, A]

  object Configured {
    def apply[A](f: Context => A) = Reader(f)
  }
}
