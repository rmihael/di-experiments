package com.experiments

import scalaz._

package object di {
  type Configured[-E, +A] = Reader[E, A]

  object Configured {
    def apply[E, A](f: E => A) = Reader(f)
  }
}
