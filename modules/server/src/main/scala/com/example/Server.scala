package com.example

import cats.Monad
import cats.effect.{ContextShift, IO, Timer}
import scala.concurrent.ExecutionContext.Implicits.global

object Server extends App {

  implicit val cs: ContextShift[IO] = IO.contextShift(global)
  implicit val timer: Timer[IO] = IO.timer(global)

  val r = exec[Int, IO](1)
  println(r)

  def exec[A, F[_]: Monad](a: A): F[A] = Foo.returnSomethingF[A, F](a)
}

object Foo {
  def returnSomethingF[A, F[_]: Monad](a: A): F[A] =
    implicitly[Monad[F]].pure(a)
}
