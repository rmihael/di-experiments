package com.experiments

import scalaz._

package object di {
  trait DI[Context, TransitiveContext] {
    type Configured[B] = Reader[Context with TransitiveContext, B]

    def context: Reader[Context, Context] = Reader(identity)
  }
}
