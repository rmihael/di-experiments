package com.experiments.di

import scalaz._

trait DI[Context, TransitiveContext] {
  type Configured[B] = Reader[Context with TransitiveContext, B]

  def context: Reader[Context, Context] = Reader(identity)
}
