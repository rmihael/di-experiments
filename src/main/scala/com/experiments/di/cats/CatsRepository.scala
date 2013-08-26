package com.experiments.di.cats

trait CatsRepository {
  def getByName(name: String): Cat
  def getAllByColor(color: String): Set[Cat]
}
