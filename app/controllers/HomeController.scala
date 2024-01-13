package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index("Welcome to play project"))
  }

  def portfolio(a:String, b:String, c:String)= Action  { implicit  request: Request[AnyContent]=>
    Ok(views.html.portfolio(a,b,c))

  }

  def form1()= Action {implicit request: Request[AnyContent]=>
    Ok(views.html.introform1())
  }

  def getRandom(a:Int): Action[AnyContent] = Action {implicit request: Request[AnyContent]=>
    if(a<=0){
      BadRequest(s"Invalid input. Thr range can not be negative or zero $a")
    }
    else{
      val rndm= new scala.util.Random
      val ans:Int= rndm.nextInt(a)
      Ok{s"the random value genertaed is $ans"}
    }
  }

  def index2(a: String, b: Int) = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.main2(a, b))
  }

//  def nameAge(name: String, age: Int) = Action {
//    Ok(views.html.main("Shivam Keshri"))
//    //      <h1>Try</h1>
//    //    })
//  }

}

/*
GET     /add/:a/:b          controllers.HomeController.add(a: Int, b: Int)
GET     /subtract/:a/:b     controllers.HomeController.sub(a: Int, b: Int)
GET     /multiply/:a/:b     controllers.HomeController.mul(a: Int, b: Int)
GET     /divide/:a/:b       controllers.HomeController.div(a: Int, b: Int)


def div(a: Double, b: Double): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
  if (b == 0) {
    BadRequest("Cannot divide by zero") // Return a BadRequest result if b is zero
  } else {
    Ok(s"The result of $a / $b is ${a / b}") // Return an Ok result with the division result
  }
}
 */