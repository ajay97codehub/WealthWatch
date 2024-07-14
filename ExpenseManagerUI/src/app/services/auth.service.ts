import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  setToken(token:string){
    localStorage.setItem("JwtToken",token);
  }
  getToken(){
    if(localStorage!==undefined){
      return localStorage.getItem("JwtToken");
    }else{
      return "";
    }
  }
  setUserName(userName:string){
    localStorage.setItem("userName",userName);
  }
  getUserName(){
    if(localStorage!==undefined){
      return localStorage.getItem("userName");
    }else{
      return "";
    }
  }
  clear(){
    localStorage.clear();
  }
  IsUserLoggedIn(){
    if(this.getToken()){
      return true;
    }else{
      return false;
    }
  }
}
