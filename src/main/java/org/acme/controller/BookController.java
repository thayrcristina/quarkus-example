package org.acme.controller;

import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.acme.model.dto.BookDTO;
import org.acme.service.BookService;

@AllArgsConstructor
@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    private BookService bookService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("name") long id) {
        return Response.ok(bookService.findById(id)).status(HttpResponseStatus.OK.code()).build();
    }

    @POST
    public Response save(BookDTO bookDTO){
        bookService.save(bookDTO);
        return Response.ok().entity("Livro salvo com sucesso!").build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        bookService.delete(id);
        return Response.ok().status(HttpResponseStatus.OK.code()).build();
    }
}
