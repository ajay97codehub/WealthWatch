import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private APPLICATION_URL="http://localhost:8081"
  
  public requestHeaders=new HttpHeaders(
    {"No-Auth":"True"}
  );
  constructor(private httpClient:HttpClient) { }
  public login(loginFormData:any){
    console.log("service called");
    return this.httpClient.post(this.APPLICATION_URL+"/loginUser",loginFormData,{headers:this.requestHeaders});
  }
  public registerNewUser(userData:any){
    return this.httpClient.post(this.APPLICATION_URL+"/api/auth/registerUser",userData,{headers:this.requestHeaders});
  }
  public getUsers(){
    return this.httpClient.get(this.APPLICATION_URL+"/api/users",{});
  }
  public getUser(userName:String){
    return this.httpClient.get(this.APPLICATION_URL+"/api/users/"+userName,{headers:this.requestHeaders});
  }
  public getUserBalance(userId:number){
    return this.httpClient.get(this.APPLICATION_URL+"/api/getTransaction/"+userId,{headers:this.requestHeaders})
  }
  public IsValid(data:any){
     let Isvalid=true;
    Object.keys(data).forEach(function(key) {
      if(!data[key]){
        Isvalid=false;
      }
    });
    return Isvalid;
  }
}
